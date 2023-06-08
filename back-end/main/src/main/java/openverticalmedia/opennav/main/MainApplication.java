package openverticalmedia.opennav.main;

import openverticalmedia.opennav.auth.EnableOpenNavAuth;
import openverticalmedia.opennav.sdk.EnableOpenNavSdk;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableOpenNavAuth
@EnableOpenNavSdk
@SpringBootApplication
public class MainApplication {

    public static void main(String[] args) {
        SpringApplication.run(MainApplication.class, args);
    }

}
