package com.example.cookie.model;

import lombok.*;

@Builder
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserCookieDto {
    private String id;
    private String name;
    private String password;
}
