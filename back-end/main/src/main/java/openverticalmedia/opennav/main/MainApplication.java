package openverticalmedia.opennav.main;

import openverticalmedia.opennav.auth.EnableOpenNavAuth;
import openverticalmedia.opennav.file.EnableOpenNavFile;
import openverticalmedia.opennav.intention.EnableOpenNavIntention;
import openverticalmedia.opennav.main.config.WebProperties;
import openverticalmedia.opennav.safe.EnableOpenNavSafe;
import openverticalmedia.opennav.sdk.EnableOpenNavSdk;
import openverticalmedia.opennav.spider.EnableOpenNavSpider;
import openverticalmedia.opennav.task.EnableOpenNavTask;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

@EnableAsync
@EnableScheduling
@EnableOpenNavAuth
@EnableOpenNavSdk
@EnableOpenNavSafe
@EnableOpenNavFile
@EnableOpenNavIntention
@EnableOpenNavTask
@EnableOpenNavSpider
@EnableConfigurationProperties(WebProperties.class)
@SpringBootApplication(scanBasePackages = "openverticalmedia.opennav")
@EntityScan(basePackages = "openverticalmedia.opennav.*.entity")
@EnableJpaRepositories(basePackages = {"openverticalmedia.opennav.*.repository"})
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
