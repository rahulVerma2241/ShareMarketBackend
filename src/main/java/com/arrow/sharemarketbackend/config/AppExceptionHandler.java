package com.arrow.sharemarketbackend.config;

import com.arrow.sharemarketbackend.model.ExceptionModel;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Arrays;
import java.util.UUID;

@ControllerAdvice
@Slf4j
public class AppExceptionHandler {

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ExceptionModel> handleException(Exception e) {
        log.error(e.getMessage(), e);
        ExceptionModel model = new ExceptionModel(UUID.randomUUID().toString(), e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value());
        return new ResponseEntity<>(model, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionModel> handleValidationException(MethodArgumentNotValidException e) {
        log.error(e.getMessage(), e);
        ExceptionModel model = new ExceptionModel(UUID.randomUUID().toString(), Arrays.toString(e.getDetailMessageArguments()), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
    }

}
