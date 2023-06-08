package openverticalmedia.opennav.sdk.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("opennav.sdk")
public class SdkProperties {
    private String smsAccessKeyId;
    private String smsAccessKeySecret;
    private String smsEndpoint;
    private String smsSign;

    private String codeRegionId;
    private String codeAccessKeyId;
    private String codeAccessKeySecret;
    private String codeEndpoint;
}
