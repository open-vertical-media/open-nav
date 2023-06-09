package openverticalmedia.opennav.safe;

import openverticalmedia.opennav.safe.config.SafeConfig;
import openverticalmedia.opennav.safe.config.SafeProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableConfigurationProperties(SafeProperties.class)
@Import({SafeConfig.class})
public @interface EnableOpenNavSafe {
}
