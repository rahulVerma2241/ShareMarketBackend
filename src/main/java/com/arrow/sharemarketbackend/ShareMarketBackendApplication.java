package com.arrow.sharemarketbackend;

import org.springdoc.core.GroupedOpenApi;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ShareMarketBackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShareMarketBackendApplication.class, args);
    }

    @Bean
    public GroupedOpenApi publicApi() {
        return GroupedOpenApi.builder().group("springshop-public")
                .pathsToMatch("/public/**").build();
    }

}
