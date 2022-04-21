package com.study.springstudy2.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
public class ApiException extends RuntimeException{
    private final ErrorCodeEnum errorCodeEnum;

    public ApiException(ErrorCodeEnum e){
        super(e.getMessage());
        this.errorCodeEnum = e;
    }
}
