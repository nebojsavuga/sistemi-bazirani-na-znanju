package com.ftn.sbnz.service.config;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.ftn.sbnz.service.exceptions.NotFoundException;
import com.ftn.sbnz.service.exceptions.UserAlreadyExistsException;
import com.ftn.sbnz.service.security.ErrorResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@RestControllerAdvice
public class ValidationHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationExceptions(
            MethodArgumentNotValidException ex) {
        List<Map<String, String>> errors = new ArrayList<>();

        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            Map<String, String> errorsMap= new HashMap<>();
            errorsMap.put("message", "Field " + fieldName + " " + errorMessage);
            errors.add(
                    errorsMap
            );
        });

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);

    }

    @ExceptionHandler(value
            = UserAlreadyExistsException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public @ResponseBody ErrorResponse
    handleUserAlreadyExistsException(UserAlreadyExistsException ex)
    {
        return new ErrorResponse(ex.getMessage());
    }

    @ExceptionHandler(value
            = NotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public @ResponseBody ErrorResponse
    handleNotFoundException(NotFoundException ex)
    {
        return new ErrorResponse(ex.getMessage());
    }
    
}
