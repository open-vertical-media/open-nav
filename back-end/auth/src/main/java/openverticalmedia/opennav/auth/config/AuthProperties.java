package openverticalmedia.opennav.auth.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties("opennav.auth")
public class AuthProperties {
    private String adminSalt;
    private String ajaxSalt;
    private String partnerSalt;
}
