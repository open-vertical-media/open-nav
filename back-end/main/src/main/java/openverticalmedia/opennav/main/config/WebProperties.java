package openverticalmedia.opennav.main.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("opennav.web")
public class WebProperties {
    private String host;
    private String staticHost;
}
