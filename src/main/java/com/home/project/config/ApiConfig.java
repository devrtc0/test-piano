package com.home.project.config;

import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApiConfig {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate(
                new HttpComponentsClientHttpRequestFactory(
                        HttpClientBuilder.create().build()));
    }
}
