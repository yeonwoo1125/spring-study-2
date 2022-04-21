package com.study.springstudy2.exception;

import com.study.springstudy2.dto.response.ErrorResponseDto;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class ApiExceptionAdvice {

    @ExceptionHandler({ApiException.class})
    public ResponseEntity<ErrorResponseDto> exceptionHandler(HttpServletRequest request, final ApiException e){
        return ResponseEntity
                .status(e.getErrorCodeEnum().getStatus())
                .body(ErrorResponseDto.builder()
                        .status(e.getErrorCodeEnum().getStatus())
                        .message(e.getErrorCodeEnum().getMessage())
                        .build());
    }

    //null pointer와 같은 기타 에러들
    @ExceptionHandler({Exception.class})
    protected ResponseEntity<ErrorResponseDto> ExceptionHandler(final NullPointerException e){
        return new ResponseEntity<>(new ErrorResponseDto(HttpStatus.INTERNAL_SERVER_ERROR.value(),e.getMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    protected ResponseEntity<ErrorResponseDto> MethodArgumentNotValidExceptionHandler(final MethodArgumentNotValidException e){
        return new ResponseEntity<>(new ErrorResponseDto(HttpStatus.BAD_REQUEST.value(),e.getMessage()), HttpStatus.BAD_REQUEST);
    }

    //SQL문이 안될때
    @ExceptionHandler({DataIntegrityViolationException.class})
    protected ResponseEntity<ErrorResponseDto> DataIntegrityViolationExceptionHandler(final DataIntegrityViolationException e){
        return new ResponseEntity<>(new ErrorResponseDto(HttpStatus.CONFLICT.value(),e.getMessage()), HttpStatus.CONFLICT);
    }

    //지원하지 않는 메서드
    @ExceptionHandler({HttpRequestMethodNotSupportedException.class})
    protected ResponseEntity<ErrorResponseDto> HttpRequestMethodNotSupportedExceptionHandler(final HttpRequestMethodNotSupportedException e){
        return new ResponseEntity<>(new ErrorResponseDto(HttpStatus.METHOD_NOT_ALLOWED.value(),e.getMessage()), HttpStatus.METHOD_NOT_ALLOWED);
    }
}
