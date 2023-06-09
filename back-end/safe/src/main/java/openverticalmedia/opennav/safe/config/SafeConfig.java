package openverticalmedia.opennav.safe.config;

import openverticalmedia.opennav.safe.interceptor.MachineInterceptor;
import openverticalmedia.opennav.safe.interceptor.TelephoneInterceptor;
import openverticalmedia.opennav.sdk.EnableOpenNavSdk;
import openverticalmedia.opennav.sdk.code.CodeTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
@EnableOpenNavSdk
public class SafeConfig {

    @Bean
    public MachineInterceptor machineInterceptor(CodeTemplate codeTemplate,
                                                 StringRedisTemplate redisTemplate){
        return new MachineInterceptor(codeTemplate,redisTemplate);
    }
    @Bean
    public TelephoneInterceptor telephoneInterceptor(StringRedisTemplate redisTemplate){
        return new TelephoneInterceptor(redisTemplate);
    }
}
