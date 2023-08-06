package openverticalmedia.opennav.sdk.config;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.oss.OSSClient;
import com.aliyuncs.IAcsClient;
import openverticalmedia.opennav.config.controller.template.TemplateConfigProperty;
import openverticalmedia.opennav.sdk.code.CodeTemplate;
import openverticalmedia.opennav.sdk.resource.ResourceProperties;
import openverticalmedia.opennav.sdk.resource.ResourceTemplate;
import openverticalmedia.opennav.sdk.sms.SmsProperties;
import openverticalmedia.opennav.sdk.sms.SmsTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SdkTemplateConfig {
    @Autowired
    TemplateConfigProperty template;

    @Bean
    public CodeTemplate codeTemplate(IAcsClient acsClient) {
        return new CodeTemplate(acsClient);
    }

    @Bean
    public SmsTemplate smsTemplate(Client client) {
        SmsProperties properties = template.get("SDK_SMS", SmsProperties.class);
        return new SmsTemplate(client, properties);
    }

    //    @Bean
//    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory redisConnectionFactory){
//        StringRedisTemplate stringRedisTemplate=new StringRedisTemplate();
//        stringRedisTemplate.setConnectionFactory(redisConnectionFactory);
//        return stringRedisTemplate;
//    }
    @Bean
    public ResourceTemplate resourceTemplate(OSSClient client) {
        ResourceProperties properties = template.get("SDK_OSS", ResourceProperties.class);
        return new ResourceTemplate(client, properties);
    }
}