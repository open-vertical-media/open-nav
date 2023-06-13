package openverticalmedia.opennav.sdk.config;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyuncs.IAcsClient;
import openverticalmedia.opennav.config.controller.template.TemplateConfigProperty;
import openverticalmedia.opennav.sdk.code.CodeTemplate;
import openverticalmedia.opennav.sdk.sms.SmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SdkConfig {
    @Autowired
    TemplateConfigProperty template;
    @Bean
    public CodeTemplate codeTemplate(IAcsClient acsClient) {
        return new CodeTemplate(acsClient);
    }

    @Bean
    public SmsTemplate smsTemplate(Client client) {
        SdkSmsProperties properties = template.get("SDK_SMS", SdkSmsProperties.class);
        return new SmsTemplate(client, properties);
    }
//    @Bean
//    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
//        StringRedisTemplate stringRedisTemplate=new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
//        return stringRedisTemplate;
//    }
}