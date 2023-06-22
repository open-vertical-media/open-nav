package openverticalmedia.opennav.sdk.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
public class SdkSmsProperties {
    private String smsAccessKeyId;
    private String smsAccessKeySecret;
    private String smsEndpoint;
}
