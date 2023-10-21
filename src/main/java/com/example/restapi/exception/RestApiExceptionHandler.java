package com.example.restapi.exception;

import com.example.restapi.controller.RestApiBController;
import com.example.restapi.controller.RestApiController;
import com.example.restapi.model.Api;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.NoSuchElementException;

@Slf4j
@RestControllerAdvice(basePackageClasses = { RestApiController.class, RestApiBController.class })
@Order(1)
public class RestApiExceptionHandler {

    @ExceptionHandler(value={Exception.class})
    public ResponseEntity exception(
            Exception e
    ) {
        log.error("RestApiExceptionHandler", e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value={IndexOutOfBoundsException.class})
    public ResponseEntity outOfBound(
            IndexOutOfBoundsException e
    ) {
        log.error("IndexOutOfBoundException", e);
        return ResponseEntity.status(200).build();
    }

    @ExceptionHandler(value={NoSuchElementException.class})
    public ResponseEntity noSuchElement(
            NoSuchElementException e
    ) {
        log.error("", e);
        var response = Api.builder()
                .resultCode(String.valueOf(HttpStatus.NOT_FOUND.value()))
                .resultMessage(HttpStatus.NOT_FOUND.getReasonPhrase())
                .build();

        return ResponseEntity
                .status(HttpStatus.NOT_FOUND)
                .body(response);
    }
}
