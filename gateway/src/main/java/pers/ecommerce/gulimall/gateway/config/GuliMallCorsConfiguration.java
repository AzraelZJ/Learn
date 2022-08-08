package pers.ecommerce.gulimall.gateway.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.reactive.CorsWebFilter;
import org.springframework.web.cors.reactive.UrlBasedCorsConfigurationSource;

/**
 * @author AzraelZJ
 * @date 2022/8/7 23:48
 * @description 跨域配置，@Configuration 标明该类是配置类，@Bean 将该对象加入到容器
 */
@Configuration
public class GuliMallCorsConfiguration {

    @Bean
    public CorsWebFilter corsWebFilter(){

        // 基于 URL 路径的跨域配置
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();

        // 跨域配置
        CorsConfiguration corsConfiguration = new CorsConfiguration();
        // 允许哪些头跨域
        corsConfiguration.addAllowedHeader("*");
        // 允许哪些请求方式跨域（GET、POST、...）
        corsConfiguration.addAllowedMethod("*");
        // 允许哪些请求来源跨域，SpringBoot 升级 2.4.0 后需使用 addAllowedOriginPattern，之前用 allowedOrigins
        corsConfiguration.addAllowedOriginPattern("*");
        // 是否允许携带 Cookie 跨域，若为 false 跨域请求会丢失 Cookie 信息
        corsConfiguration.setAllowCredentials(true);

        source.registerCorsConfiguration("/**", corsConfiguration);

        return new CorsWebFilter(source);
    }
}
