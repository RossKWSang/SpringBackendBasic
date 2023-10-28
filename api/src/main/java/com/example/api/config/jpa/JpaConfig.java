package com.example.api.config.jpa;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


// 다른 모듈의 패키지명이 달라 Bean을 인식하지 못하는 문제가 생겼을 때 해당 설정을 필수로 함
@Configuration
@EntityScan(basePackages = "com.example.db") // 엔터티를 읽는다
@EnableJpaRepositories(basePackages = "com.example.db") // 리포지토리를 읽는다
public class JpaConfig {
}
