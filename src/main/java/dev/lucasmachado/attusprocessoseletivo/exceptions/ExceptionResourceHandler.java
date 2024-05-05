package dev.lucasmachado.attusprocessoseletivo.exceptions;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@ControllerAdvice
public class ExceptionResourceHandler {

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<StandardError> objectNotFound(NoSuchElementException e, HttpServletRequest request){
        StandardError err = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(err);
    }

//   ConstraintViolationException
@ExceptionHandler(ConstraintViolationException.class)
public ResponseEntity<StandardError> objectNotFound(ConstraintViolationException e, HttpServletRequest request){
    ValidationError err = new ValidationError(HttpStatus.BAD_REQUEST.value(),"Validation error!", System.currentTimeMillis());
    e.getConstraintViolations().stream().forEach(x -> err.addError(new FieldMessage(x.getPropertyPath().toString(),x.getMessage())));
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(err);
}

}
