package com.erros.Exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class RestExceptionHandler extends RuntimeException{
    @ExceptionHandler(HttpMessageNotReadableException.class )
    public ResponseEntity<ExceptionDTO> handleIOException(HttpMessageNotReadableException e){
        var exceptionDTO = new ExceptionDTO(HttpStatus.BAD_REQUEST, e.getMessage());
        return ResponseEntity.badRequest().body(exceptionDTO);
    }
}
