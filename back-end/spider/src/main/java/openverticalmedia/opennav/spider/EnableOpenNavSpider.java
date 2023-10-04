package openverticalmedia.opennav.spider;

import openverticalmedia.opennav.spider.config.SpiderProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@EnableConfigurationProperties(SpiderProperties.class)
public @interface EnableOpenNavSpider {
}
