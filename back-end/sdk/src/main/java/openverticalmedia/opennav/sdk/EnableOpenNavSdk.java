package openverticalmedia.opennav.sdk;

import openverticalmedia.opennav.sdk.config.SdkConfig;
import openverticalmedia.opennav.sdk.config.SdkProperties;
import openverticalmedia.opennav.sdk.config.SdkClientConfig;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableConfigurationProperties(SdkProperties.class)
@Import({SdkClientConfig.class, SdkConfig.class})
public @interface EnableOpenNavSdk {
}
