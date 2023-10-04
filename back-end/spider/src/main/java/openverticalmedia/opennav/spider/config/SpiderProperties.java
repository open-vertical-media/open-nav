package openverticalmedia.opennav.spider.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;

@Data
@ConfigurationProperties("opennav.spider")
public class SpiderProperties {
    private List<String> keywords;
}