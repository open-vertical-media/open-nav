package openverticalmedia.opennav.auth.interceptor;

import cn.hutool.core.util.StrUtil;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import openverticalmedia.opennav.common.annotation.PassToken;
import openverticalmedia.opennav.common.exception.NotLoginException;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.lang.reflect.Method;

@Slf4j
public class AuthenticationInterceptor implements HandlerInterceptor {

    @Setter
    private String salt;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object object) throws Exception {
        if (object instanceof HandlerMethod) {
            HandlerMethod handlerMethod = (HandlerMethod) object;
            Method method = handlerMethod.getMethod();
            //检查是否有PassToken注释，有则跳过认证
            if (method.isAnnotationPresent(PassToken.class)) {
                return true;
            }
            String token = request.getHeader("Authorization");
            if (StrUtil.isBlankOrUndefined(token)) {
                log.info("错误的请求：{}", request.getRequestURI());
                throw new NotLoginException("凭证认证丢失");
            }
            token = token.replace("Bearer ", "")
                    .replace("bearer ", "");
            // 验证 token
            JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(salt)).build();
            try {
                jwtVerifier.verify(token);
            } catch (JWTVerificationException e) {
                log.warn("错误的请求：{}, JWT：{}", request.getRequestURI(), token);
                response.setContentType("application/json; charset=utf-8");
                response.setStatus(401);
                PrintWriter writer = response.getWriter();
                writer.print("凭证认证错误");
                writer.close();
                response.flushBuffer();
                return false;
            }
            return true;
        }else{
            return true;
        }
    }
}
