package com.sylvie.sprigchallenge.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import java.util.stream.Collectors;

@RestControllerAdvice
public class StudentExceptionHandler {

    @ExceptionHandler(RecordNotFoundException.class)
    public ResponseEntity<StudentErrorResponse> handleStudentNotFoundException(RecordNotFoundException e) {
        StudentErrorResponse errorResp = new StudentErrorResponse(HttpStatus.NOT_FOUND.value(),e.getMessage(),System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResp);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<StudentErrorResponse> handleStudentValidationException(MethodArgumentNotValidException e) {
        String details = e.getBindingResult().getFieldErrors().stream()
            .map(er -> er.getField() + ": " + er.getDefaultMessage())
            .collect(Collectors.joining("; "));

        StudentErrorResponse errorResp = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), details, System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResp);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<StudentErrorResponse> handleMethodArgsException(MethodArgumentTypeMismatchException e) {
        StudentErrorResponse errorResp = new StudentErrorResponse(HttpStatus.BAD_REQUEST.value(), "Id Provided invalid, please supply positive integer.", System.currentTimeMillis());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResp);
    }

//    @ExceptionHandler(Exception.class)
//    public ResponseEntity<StudentErrorResponse> handleGenericException(Exception e) {
//        StudentErrorResponse errorResp = new StudentErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(),"An internal error occurred.",System.currentTimeMillis());
//        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResp);
//    }
}
