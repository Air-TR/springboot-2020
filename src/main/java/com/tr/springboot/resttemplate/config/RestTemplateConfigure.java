package com.tr.springboot.resttemplate.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;

/**
 * 以下配置，使得 RestTemplate 可以通过普通 URL 调用
 *
 * @Author TR
 * @date 2022/6/25 下午3:27
 */
@Configuration
public class RestTemplateConfigure {

    @LoadBalanced
    @Bean
    RestTemplate loadBalanced() {
        return new RestTemplate();
    }

    @Primary
    @Bean
    RestTemplate restTemplate() {
        return new RestTemplate();
    }

}
