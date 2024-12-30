package com.spring.mvcproject.chap6_3.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

// API에서 발생하는 수많은 예외상황들을 도맡아서 처리하는 AOP클래스
@ControllerAdvice
public class GlobalExceptionHandler {

    // 예외처리 메서드
    @ExceptionHandler(Exception.class)  // 받아서 처리할 예외의 이름
    public ResponseEntity<?> handleClientException(Exception e) {
        return ResponseEntity.badRequest()
                .body(e.getMessage());
    }
}
