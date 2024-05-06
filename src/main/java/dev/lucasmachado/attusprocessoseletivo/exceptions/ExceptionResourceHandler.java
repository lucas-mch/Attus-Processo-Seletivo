package dev.lucasmachado.attusprocessoseletivo.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionResourceHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandardError> objectNotFound(NoSuchElementException e, HttpServletRequest request) {
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StandardError> dataIntegrity(MethodArgumentNotValidException e, HttpServletRequest request) {
        ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(), "Validation error!", System.currentTimeMillis());

        for (FieldError x : e.getBindingResult().getFieldErrors()) {
            err.addError(new FieldMessage(x.getField(), x.getDefaultMessage()));
        }

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
    }

}
