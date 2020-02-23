package com.ipl.iplproj.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ipl.iplproj.exception.MyBadRequestException;



@ControllerAdvice
public class ControllerAdvisor extends ResponseEntityExceptionHandler {

    @ExceptionHandler(MyBadRequestException.class)
    public ResponseEntity teamNotFoundException(){
        return new ResponseEntity<>("404: Requested url cannot be found ",HttpStatus.NOT_FOUND);
    }
}
    