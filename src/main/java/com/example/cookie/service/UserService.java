package com.example.cookie.service;

import com.example.cookie.model.LoginRequest;
import com.example.cookie.db.UserCookieRepository;
import com.example.cookie.model.UserCookieDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserCookieRepository userCookieRepository;
    public void login(
            LoginRequest loginRequest,
            HttpServletResponse httpServletResponse
    ) {
        var id = loginRequest.getId();
        var pw = loginRequest.getPassword();

        var optionalUser = userCookieRepository.findByName(id);

        if (optionalUser.isPresent()) {
            var userCookieDto = optionalUser.get();

            if (userCookieDto.getPassword().equals(pw)) {
                // cookie 해당 정보를 저장
                var cookie = new Cookie("authorization-cookie", userCookieDto.getId());
                cookie.setDomain("localhost"); // naver.com, daum.net
                cookie.setPath("/"); // 쿠키를 모든 경로에서 사용하겠다.
                cookie.setHttpOnly(true);
                cookie.setMaxAge(-1); // 초 단위로 쿠키를 사용할 시간을 설정 -1은 브라우저가 종료될 때까지 (사실상 session과 동일)

                httpServletResponse.addCookie(cookie);
            }

        } else {
            throw new RuntimeException("User Not Found");
        }
    }
}
