package openverticalmedia.opennav.safe.interceptor;

import cn.hutool.core.util.NumberUtil;
import cn.hutool.core.util.StrUtil;
import openverticalmedia.opennav.sdk.code.CodeTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

public class MachineInterceptor implements HandlerInterceptor {
    final CodeTemplate codeTemplate;
    final StringRedisTemplate template;

    public MachineInterceptor(CodeTemplate codeTemplate,StringRedisTemplate template) {
        this.codeTemplate = codeTemplate;
        this.template=template;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String nvc = request.getHeader("nvc");
        int status = 500;
        if (StrUtil.isNotBlank(nvc)) {
            String result = codeTemplate.check(nvc);
            switch (result) {
                case "100":
                case "200":
                    return true;
                default:
                    status = NumberUtil.parseInt(result);
            }
        }
        response.setContentType("application/json; charset=utf-8");
        response.setStatus(status);
        PrintWriter writer = response.getWriter();
        writer.print("校验失败");
        writer.close();
        response.flushBuffer();
        return false;
    }
}
