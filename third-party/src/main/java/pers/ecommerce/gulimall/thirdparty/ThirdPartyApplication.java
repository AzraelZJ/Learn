package pers.ecommerce.gulimall.thirdparty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @author AzraelZJ
 * @date 2022/8/15 11:30
 */
@EnableDiscoveryClient
@SpringBootApplication
public class ThirdPartyApplication {

    public static void main(String[] args) {

        SpringApplication.run(ThirdPartyApplication.class, args);
    }

}
