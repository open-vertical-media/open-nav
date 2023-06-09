package openverticalmedia.opennav.safe.interceptor;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class TelephoneInterceptor implements HandlerInterceptor {
    final StringRedisTemplate template;

    public TelephoneInterceptor(StringRedisTemplate template) {
        this.template = template;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        String ntc = request.getHeader("ntc");
        String errorMsg = "验证码错误";
        if (StrUtil.isNotBlank(ntc)) {
            String tel = template.opsForValue().get("tel:" + ntc);
            //TODO 获取数据里面的手机号 & 校验手机号
            Object telephone = request.getAttribute("telephone");
            if (StrUtil.isNotBlank(tel) && telephone != null) {
                if (tel.equals(telephone.toString())) {
                    String code = template.opsForValue().get("code:" + ntc);
                    if (ntc.equals(code)) {
                        template.opsForValue().getAndDelete("code:" + ntc);
                        template.opsForValue().getAndDelete("tel:" + ntc);
                        return true;
                    }
                    //次数限制
                    String numberString = template.opsForValue().get("code:" + ntc);
                    if (StrUtil.isBlank(numberString)) {
                        numberString = "0";
                    }
                    int number = NumberUtil.parseInt(numberString) + 1;
                    //限制3次验证
                    if (number > 3) {
                        template.opsForValue().getAndDelete("code:" + ntc);
                        template.opsForValue().getAndDelete("tel:" + ntc);
                        errorMsg = "错误次数过多，请重新发送";
                    }
                }
            }
        }
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(403);
        PrintWriter writer = response.getWriter();
        writer.print(errorMsg);
        writer.close();
        response.flushBuffer();
        return false;
    }
}