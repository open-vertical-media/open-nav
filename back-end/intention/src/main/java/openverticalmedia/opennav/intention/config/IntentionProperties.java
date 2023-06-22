package openverticalmedia.opennav.intention.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("opennav.intention")
public class IntentionProperties {
    private String sign;
    private String telephone;
    private String templateCode;
}
