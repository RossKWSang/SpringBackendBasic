package com.example.api.interceptor;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.resource.ResourceHttpRequestHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Slf4j
@RequiredArgsConstructor
@Component // 이것이 있으면 주입 될 수 있는 클래스가 된다.
public class AuthorizationInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Authorization Interceptor url : {}", request.getRequestURL());

        // GET, Chrome의 경우 GET, POST OPTIONS -> 통과

        if(HttpMethod.OPTIONS.matches(request.getMethod())) {
            return true;
        }

        if(handler instanceof ResourceHttpRequestHandler) {
            return true;
        }

        // Header 검증
        return true; // 일단 통과 처리
    }
}
