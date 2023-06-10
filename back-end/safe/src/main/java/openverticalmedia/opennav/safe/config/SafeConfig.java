package openverticalmedia.opennav.safe.config;

import openverticalmedia.opennav.safe.interceptor.AliyunMachineInterceptor;
import openverticalmedia.opennav.safe.interceptor.AliyunTelephoneInterceptor;
import openverticalmedia.opennav.sdk.EnableOpenNavSdk;
import openverticalmedia.opennav.sdk.code.CodeTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@EnableOpenNavSdk
public class SafeConfig {

    @Bean
    public AliyunMachineInterceptor machineInterceptor(CodeTemplate codeTemplate,
                                                       StringRedisTemplate redisTemplate){
        return new AliyunMachineInterceptor(codeTemplate,redisTemplate);
    }
    @Bean
    public AliyunTelephoneInterceptor telephoneInterceptor(StringRedisTemplate redisTemplate){
        return new AliyunTelephoneInterceptor(redisTemplate);
    }
}
