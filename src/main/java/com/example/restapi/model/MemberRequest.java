package com.example.restapi.model;

import lombok.Data; // 해당 클래스가 가지고 있는 메소드를 자동으로 만들어준다
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MemberRequest {
    private String name;
    private String phoneNumber;
    private String email;
}
