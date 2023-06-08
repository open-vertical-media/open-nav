package openverticalmedia.opennav.sdk.config;

import com.aliyun.dysmsapi20170525.Client;
import com.aliyun.teaopenapi.models.Config;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SdkConfig {
    @Autowired
    SdkProperties properties;

    @Bean
    public Client aliyunSmsClient() throws Exception {
        Config config = new Config()
                .setAccessKeyId(properties.getSmsAccessKeyId())
                .setAccessKeySecret(properties.getSmsAccessKeyId())
                .setEndpoint(properties.getSmsEndpoint());
        return new Client(config);
    }
    @Bean
    public IAcsClient aliyunCodeClient(){
        IClientProfile profile= DefaultProfile.getProfile(
                properties.getCodeRegionId(),
                properties.getCodeAccessKeyId(),
                properties.getCodeAccessKeySecret()
        );
        return new DefaultAcsClient(profile);
    }
}
