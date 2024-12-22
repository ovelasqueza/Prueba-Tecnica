package com.ofva.backend.exceptions;

import com.ofva.backend.models.responses.Response;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Set;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Response<Object>> handleValidationExceptions(MethodArgumentNotValidException ex) {
        Response<Object> response = new Response<>();

        StringBuilder errorMessage = new StringBuilder();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            errorMessage.append(error.getDefaultMessage()).append(" ");
        });

        response.setMessage(errorMessage.toString().trim());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }
}
