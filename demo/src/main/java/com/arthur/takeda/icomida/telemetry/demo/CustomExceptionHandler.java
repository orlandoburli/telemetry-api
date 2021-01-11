package com.arthur.takeda.icomida.telemetry.demo;

import com.arthur.takeda.icomida.telemetry.demo.exception.NotFoundException;
import com.arthur.takeda.icomida.telemetry.demo.exception.RestExceptionModel;
import com.arthur.takeda.icomida.telemetry.demo.exception.WrongArgumentException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class CustomExceptionHandler {
    @ExceptionHandler({NotFoundException.class})
    protected ResponseEntity<Object> handleAll(NotFoundException ex) {
        return new ResponseEntity(new RestExceptionModel(HttpStatus.NOT_FOUND, ex.getMessage()), new HttpHeaders(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler({WrongArgumentException.class})
    protected ResponseEntity<Object> handleAll(WrongArgumentException ex) {
        return new ResponseEntity(new RestExceptionModel(HttpStatus.BAD_REQUEST, ex.getMessage()), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });
        return errors;
    }
}
