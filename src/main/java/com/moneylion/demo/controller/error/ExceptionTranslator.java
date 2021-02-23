package com.moneylion.demo.controller.error;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionTranslator {

    Logger log = LoggerFactory.getLogger(ExceptionHandler.class);
    @ExceptionHandler
    public ResponseEntity<?> handleException(Exception ex) {
        log.error(ex.getLocalizedMessage());
        return new ResponseEntity<>(HttpStatus.NOT_MODIFIED);

    }
}
