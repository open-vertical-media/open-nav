package openverticalmedia.opennav.intention;

import openverticalmedia.opennav.intention.config.IntentionProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableConfigurationProperties(IntentionProperties.class)
public @interface EnableOpenNavIntention {
}
