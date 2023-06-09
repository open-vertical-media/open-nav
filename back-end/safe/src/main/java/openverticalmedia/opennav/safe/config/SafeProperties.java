package openverticalmedia.opennav.safe.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("opennav.safe")
public class SafeProperties {
    private String smsTemplateCode;
}
