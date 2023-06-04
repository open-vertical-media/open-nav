package openverticalmedia.opennav.auth.config;

import openverticalmedia.opennav.auth.interceptor.AuthenticationInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AuthAutoConfig {
    @Autowired
    AuthProperties properties;
    @Bean(name = "admin")
    public AuthenticationInterceptor admin(){
        AuthenticationInterceptor authenticationInterceptor= new AuthenticationInterceptor();
        authenticationInterceptor.setSalt(properties.getAdminSalt());
        return authenticationInterceptor;
    }
    @Bean(name = "ajax")
    public AuthenticationInterceptor ajax(){
        AuthenticationInterceptor authenticationInterceptor= new AuthenticationInterceptor();
        authenticationInterceptor.setSalt(properties.getAjaxSalt());
        return authenticationInterceptor;
    }
    @Bean(name = "partner")
    public AuthenticationInterceptor partner(){
        AuthenticationInterceptor authenticationInterceptor= new AuthenticationInterceptor();
        authenticationInterceptor.setSalt(properties.getPartnerSalt());
        return authenticationInterceptor;
    }
}
