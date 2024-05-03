package com.example.QuanLyTruongHoc.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class MyHandler {

    @ExceptionHandler
    public ResponseEntity<ErrolResponse> batLoi(Exception e){
        ErrolResponse error=new ErrolResponse(HttpStatus.BAD_REQUEST.value(),e.getMessage());
        return ResponseEntity.badRequest().body(error);
    }

}
