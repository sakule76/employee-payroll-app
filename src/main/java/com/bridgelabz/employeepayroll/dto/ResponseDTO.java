package com.bridgelabz.employeepayroll.dto;

import lombok.Data;
import org.springframework.http.HttpStatus;

public @Data class ResponseDTO {
    private String message;
    private int statusCode;
    private Object data;

    public ResponseDTO(String message, HttpStatus statusCode, Object data) {
        this.message=message;
        this.statusCode = statusCode.value();
        this.data = data;
    }
}
