package com.erros.Exception;

import org.springframework.http.HttpStatus;


public record ExceptionDTO(HttpStatus status, String message){}