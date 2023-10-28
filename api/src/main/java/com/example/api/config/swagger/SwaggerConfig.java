package com.example.api.config.swagger;

import com.fasterxml.jackson.databind.ObjectMapper;
import io.swagger.v3.core.jackson.ModelResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


// Swagger페이지의 엔터티 속성값이 CamelCase로 기재되는 것을 snake_case로 변경해주기 위한 설정
@Configuration
public class SwaggerConfig {

    @Bean
    public ModelResolver modelResolver(ObjectMapper objectMapper) {
        return new ModelResolver(objectMapper);
    }
}
