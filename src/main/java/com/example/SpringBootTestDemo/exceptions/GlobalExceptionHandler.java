package com.example.SpringBootTestDemo.exceptions;

import com.example.SpringBootTestDemo.model.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalExceptionHandler extends ResponseEntityExceptionHandler{
    @ExceptionHandler(value = StudentNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleStudentNotFoundException(StudentNotFoundException ex, WebRequest request)
    {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, ex.getMessage());
        return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);

    }
}
