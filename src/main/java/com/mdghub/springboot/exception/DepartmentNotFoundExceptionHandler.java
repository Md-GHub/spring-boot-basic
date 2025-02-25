package com.mdghub.springboot.exception;


import com.mdghub.springboot.entity.ErrorMessage;
import com.mdghub.springboot.error.DepartmentNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@ResponseStatus
public class DepartmentNotFoundExceptionHandler extends ResponseEntityExceptionHandler {


    @ExceptionHandler(DepartmentNotFoundException.class)
    public ResponseEntity<ErrorMessage>
    departmentNotFoundException(DepartmentNotFoundException e , WebRequest request) {

        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,e.getMessage());

        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }


}
