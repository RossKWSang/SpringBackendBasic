package com.example.restapi.model;

import com.example.restapi.annotation.PhoneNumber;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@JsonNaming(value = PropertyNamingStrategies.SnakeCaseStrategy.class)
public class UserRegisterRequest {

    // @NotNull    // != null
    // @NotEmpty   // != null && name != ""
    // @NotBlank   // != null && name != "" && name != "  "

    // name과 nickName 둘 중 하나만 있으면 오류가 없는 것으로 처리하려고 함
    // 이런 로직을 처리하는 Annotation은 없으므로 아래 AssertTrue로 새로 정의할 것
    private String name;
    private String nickName;

    @Size(min=1, max=12)
    @NotBlank
    private String password;

    @NotNull
    @Min(1)
    @Max(100)
    private Integer age;

    @Email
    private String email;

    @PhoneNumber
    private String phoneNumber;

    @FutureOrPresent
    private LocalDateTime registerAt;

    @AssertTrue(message = "name or nickname은 존재해야 합니다.")
    public boolean nameCheck() {
        if (!name.isBlank()) {
            return true;
        }

        if (!nickName.isBlank()) {
            return true;
        }

        return false;
    }

}
