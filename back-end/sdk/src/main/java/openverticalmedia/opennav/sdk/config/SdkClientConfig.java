package openverticalmedia.opennav.sdk.config;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.oss.OSSClient;
import com.aliyun.teaopenapi.models.Config;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import openverticalmedia.opennav.config.controller.template.TemplateConfigProperty;
import openverticalmedia.opennav.sdk.code.CodeProperties;
import openverticalmedia.opennav.sdk.resource.ResourceProperties;
import openverticalmedia.opennav.sdk.sms.SmsProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SdkClientConfig {

    @Autowired
    TemplateConfigProperty template;

    @Bean
    public Client aliyunSmsClient() throws Exception {
        SmsProperties properties = template.get("SDK_SMS", SmsProperties.class);
        Config config = new Config()
                .setAccessKeyId(properties.getSmsAccessKeyId())
                .setAccessKeySecret(properties.getSmsAccessKeySecret())
                .setEndpoint(properties.getSmsEndpoint());
        return new Client(config);
    }

    @Bean
    public IAcsClient aliyunCodeClient(){
        CodeProperties properties = template.get("SDK_CODE", CodeProperties.class);
        IClientProfile profile= DefaultProfile.getProfile(
                properties.getCodeRegionId(),
                properties.getCodeAccessKeyId(),
                properties.getCodeAccessKeySecret()
        );
        return new DefaultAcsClient(profile);
    }

    @Bean
    public OSSClient aliyunOssClient(){
        ResourceProperties properties = template.get("SDK_OSS", ResourceProperties.class);
        return new OSSClient(properties.getEndpoint(), properties.getAccessKeyId(), properties.getAccessKeySecret());
    }
}
