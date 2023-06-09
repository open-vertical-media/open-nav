package openverticalmedia.opennav.main.interceptor;

import openverticalmedia.opennav.auth.interceptor.AuthenticationInterceptor;
import openverticalmedia.opennav.safe.interceptor.MachineInterceptor;
import openverticalmedia.opennav.safe.interceptor.TelephoneInterceptor;
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
    @Autowired
    MachineInterceptor machineInterceptor;
    @Autowired
    TelephoneInterceptor telephoneInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(admin)
                .excludePathPatterns("/admin/auth/token")
                .addPathPatterns("/admin/**");

//        registry.addInterceptor(ajax)
//                .excludePathPatterns("/ajax/auth/token")
//                .addPathPatterns("/ajax/**");

        registry.addInterceptor(partner)
                .excludePathPatterns("/partner/auth/token")
                .addPathPatterns("/partner/**");

        registry.addInterceptor(machineInterceptor)
                .addPathPatterns("/ajax/safe/sms");
        registry.addInterceptor(telephoneInterceptor)
                .addPathPatterns("/ajax/intention/record");
    }
}
