package com.example.api.account;

import com.example.api.account.model.AccountMeResponse;
import com.example.db.account.AccountEntity;
import com.example.db.account.AccountRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/account")
public class AccountApiController {

    private final AccountRepository accountRepository;

    @GetMapping("/me")
    public AccountMeResponse save() {
        return AccountMeResponse.builder()
                .name("홍길동")
                .email("A@gmail.com")
                .registeredAt(LocalDateTime.now()) //"2023-10-28T20:59:35.587852" => ISO8601 Spec
                .build();
    }
}

