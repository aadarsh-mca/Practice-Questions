package com.cdac.vehicle.controllerAdvice;

import com.cdac.vehicle.dto.GenericResponse;
import com.cdac.vehicle.exception.DuplicateResourceFoundException;
import com.cdac.vehicle.exception.MissingRequestParameterException;
import com.cdac.vehicle.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalRestExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleNoResourceFound(ResourceNotFoundException error) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new GenericResponse(error.getMessage()));
    }

    @ExceptionHandler(DuplicateResourceFoundException.class)
    public ResponseEntity<?> handleDuplicateResourceException(DuplicateResourceFoundException error) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponse(error.getMessage()));
    }

    @ExceptionHandler(MissingRequestParameterException.class)
    public ResponseEntity<?> handleMissingRequestParameterException(MissingRequestParameterException error) {
        return ResponseEntity.badRequest().body(new GenericResponse(error.getMessage()));
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<?> handleMissingServletRequestParameterException(MissingServletRequestParameterException error) {
        return ResponseEntity.badRequest().body(new GenericResponse(error.getMessage()));
    }

//    @ExceptionHandler(RuntimeException.class)
//    public ResponseEntity<?> handleOtherException(RuntimeException error) {
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new GenericResponse(error.getMessage()));
//    }

}
