package com.example.api.domain.user.business;

import com.example.api.common.annotation.Business;
import com.example.api.domain.user.controller.model.UserRegisterRequest;
import com.example.api.domain.user.controller.model.UserResponse;
import com.example.api.domain.user.converter.UserConverter;
import com.example.api.domain.user.service.UserService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Business
public class UserBusiness {
    private final UserService userService;
    private final UserConverter userConverter;

    /*
     * 사용자에 대한 가입처리 로직
     */
    public UserResponse register(UserRegisterRequest request) {

    }
}
