package openverticalmedia.opennav.sdk;

import openverticalmedia.opennav.sdk.config.SdkClientConfig;
import openverticalmedia.opennav.sdk.config.SdkTemplateConfig;
import org.springframework.context.annotation.Import;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Import({SdkClientConfig.class, SdkTemplateConfig.class})
public @interface EnableOpenNavSdk {
}
