package openverticalmedia.opennav.safe.interceptor;

import cn.hutool.core.util.StrUtil;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class TelephoneInterceptor implements HandlerInterceptor {
    final StringRedisTemplate template;
    public TelephoneInterceptor(StringRedisTemplate template){
        this.template=template;
    }
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ntc = request.getHeader("ntc");
        String ntr = request.getHeader("ntr");
        if(StrUtil.isNotBlank(ntc)&&StrUtil.isNotBlank(ntr)){
            String code = template.opsForValue().get("ntc:" + ntc);
            if(ntc.equals(code)){
                return true;
            }
        }
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(403);
        PrintWriter writer = response.getWriter();
        writer.print("验证码错误");
        writer.close();
        response.flushBuffer();
        return false;
    }
}
