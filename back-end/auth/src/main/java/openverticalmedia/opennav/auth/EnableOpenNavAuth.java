package openverticalmedia.opennav.auth;

import openverticalmedia.opennav.auth.config.AuthAutoConfig;
import openverticalmedia.opennav.auth.config.AuthProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableConfigurationProperties(AuthProperties.class)
@Import(AuthAutoConfig.class)
public @interface EnableOpenNavAuth {
}
