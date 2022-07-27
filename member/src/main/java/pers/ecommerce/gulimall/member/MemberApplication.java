package pers.ecommerce.gulimall.member;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author AzraelZJ
 *
 * 远程调用别的服务：
 *     1. 引入 OpenFeign；
 *     2. 编写一个接口，告诉 Spring Cloud 这个接口需要调用远程服务；在接口内声明接口的每一个方法调用哪个远程服务的哪个请求；
 *     3. 开启远程调用功能（@EnableFeignClients）
 */
@EnableFeignClients(basePackages = "pers.ecommerce.gulimall.member.feign")
@EnableDiscoveryClient
@SpringBootApplication
public class MemberApplication {

    public static void main(String[] args) {

        SpringApplication.run(MemberApplication.class, args);
    }

}
