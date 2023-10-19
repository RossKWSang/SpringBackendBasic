package com.example.restapi.model;

import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonNaming(PropertyNamingStrategies.SnakeCaseStrategy.class) // Json 데이터를 볼 때는 Snake case로 표기
public class UserRequest {
    private String userName;
    private Integer userAge; // Json을 사용할 때 int형은 기본값이 0이므로 Integer를 사용하도록 한다.
    private String email;
    private Boolean isKorean;
}
