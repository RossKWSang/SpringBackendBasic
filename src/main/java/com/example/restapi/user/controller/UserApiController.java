package com.example.restapi.user.controller;

import com.example.restapi.user.db.UserEntity;
import com.example.restapi.user.db.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequiredArgsConstructor // 생성자로 userRepository를 주입받겠다는 의미
@RestController
@RequestMapping("/api/user")
public class UserApiController {

    private final UserRepository userRepository;

    @GetMapping("/find-all")
    public List<UserEntity> findAll() {
        return userRepository.findAll();
    }

    @GetMapping("/name")
    public void autoSave(
            @RequestParam String name
    ) {
        var user = UserEntity.builder()
                .name(name)
                .age(30)
                .email("dummy@gmail.com")
                .build();

        userRepository.save(user);
    }
}
