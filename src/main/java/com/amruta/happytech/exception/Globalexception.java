package com.amruta.happytech.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDate;

@RestControllerAdvice
public class Globalexception {
    @ExceptionHandler(value = ResourceNotFoundException.class)
    public ResponseEntity<apiResponse> resourceNotFoundExceptionHandler(ResourceNotFoundException e) {

        apiResponse apr = new apiResponse();
        apr.setErrorcode("abc1234");
        apr.setErrormsg(e.getMessage());
        apr.setLocatedate(LocalDate.now());
        return  new ResponseEntity<>(apr, HttpStatus.NOT_FOUND);
    }
}









