package com.example.restapi.common;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Api<T> {

    private T body;
    private Pagination pagination;
}
