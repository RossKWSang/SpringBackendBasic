package com.example.session.service;

import com.example.session.db.UserRepository;
import com.example.session.model.LoginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public void login(
            LoginRequest loginRequest,
            HttpSession httpSession
    ) {
        var name = loginRequest.getName();
        var pw = loginRequest.getPassword();

        var optionalUser = userRepository.findByName(name);

        if (optionalUser.isPresent()) {
            var userDto = optionalUser.get();

            if(userDto.getPassword().equals(pw)) {
                // 세션에 정보 저장
                httpSession.setAttribute("USER", userDto);

            } else {
                throw new RuntimeException("Password Not Match");
            }

        } else {
            throw new RuntimeException("User Not Found");
        }
    }
}
