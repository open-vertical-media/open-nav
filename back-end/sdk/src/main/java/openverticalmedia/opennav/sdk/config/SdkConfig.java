package openverticalmedia.opennav.sdk.config;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyuncs.IAcsClient;
import openverticalmedia.opennav.sdk.code.CodeTemplate;
import openverticalmedia.opennav.sdk.sms.SmsTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.StringRedisTemplate;

@Configuration
public class SdkConfig {
    @Bean
    public CodeTemplate codeTemplate(IAcsClient acsClient) {
        return new CodeTemplate(acsClient);
    }

    @Bean
    public SmsTemplate smsTemplate(Client client, SdkProperties properties) {
        return new SmsTemplate(client, properties);
    }
//    @Bean
//    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
//        StringRedisTemplate stringRedisTemplate=new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
//        return stringRedisTemplate;
//    }
}