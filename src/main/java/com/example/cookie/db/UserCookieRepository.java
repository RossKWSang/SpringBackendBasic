package com.example.cookie.db;

import com.example.cookie.model.UserCookieDto;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserCookieRepository {
    private final List<UserCookieDto> userCookieList = new ArrayList<>();

    public Optional<UserCookieDto> findById(String id) {
        return userCookieList
                .stream()
                .filter(it -> it.getId().equals(id))
                .findFirst();
    }

    public Optional<UserCookieDto> findByName(String name) {
        return userCookieList
                .stream()
                .filter(it -> it.getName().equals(name))
                .findFirst();
    }

    @PostConstruct
    public void init() {
        userCookieList.add(new UserCookieDto(
                UUID.randomUUID().toString(),
                "홍길동",
                "1234"
                )
        );

        userCookieList.add(new UserCookieDto(
                        UUID.randomUUID().toString(),
                        "섬길동",
                        "1234"
                )
        );

        userCookieList.add(new UserCookieDto(
                        UUID.randomUUID().toString(),
                        "이길동",
                        "1234"
                )
        );
    }
}
