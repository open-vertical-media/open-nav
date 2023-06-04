package openverticalmedia.opennav.main.interceptor;

import openverticalmedia.opennav.auth.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorRegister implements WebMvcConfigurer {
    @Autowired
    AuthenticationInterceptor admin;
    @Autowired
    AuthenticationInterceptor ajax;
    @Autowired
    AuthenticationInterceptor partner;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(admin)
                .addPathPatterns("/admin/**");
        registry.addInterceptor(ajax)
                .addPathPatterns("/ajax/**");
        registry.addInterceptor(partner)
                .addPathPatterns("/partner/**");
    }
}
