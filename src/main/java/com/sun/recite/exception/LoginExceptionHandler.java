package com.sun.recite.exception;

import com.sun.recite.models.JsonResult;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class LoginExceptionHandler {
    @ExceptionHandler(value = LoginException.class)
    public ResponseEntity<?> errorHandler(HttpServletRequest request,Exception e){
        return ResponseEntity.ok(new JsonResult(e.getMessage(),403));
    }
}
