package com.sun.recite.exception;

import javax.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.sun.recite.models.JsonResult;
/**
 * @author sun
 */
@ControllerAdvice
public class ValidExceptionHandler {
	
	@ExceptionHandler(value = ValidException.class)
	public ResponseEntity<?> errorHandler(HttpServletRequest request,Exception e){
		return ResponseEntity.ok(new JsonResult(e.getMessage(),201));
	}
}
