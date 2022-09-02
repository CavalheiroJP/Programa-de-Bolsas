package com.project.products.config.validacao;

import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;



@RestControllerAdvice
public class ValidationErrorHandler {
	
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public Map<String, String> handleValidationException(MethodArgumentNotValidException e){
		Map<String, String> errors = new HashMap<>();
		e.getBindingResult().getAllErrors().forEach((error)->{
		String fieldName = ((FieldError)error).getField();
		String errorMessage = error.getDefaultMessage();
		errors.put(fieldName, errorMessage);
	});
		return errors;
	}
	
	@ResponseStatus(HttpStatus.NOT_FOUND)
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionResponse> NotFound (NotFoundException e, HttpServletRequest request){
		ExceptionResponse errors = new ExceptionResponse();
		errors.setStatus_code(HttpStatus.NOT_FOUND.value());
		errors.setMessage("Object Not Found.");
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errors);
	}
		
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(InternalServerErrorException.class)
	public ResponseEntity<ExceptionResponse> InternalServerError(InternalServerErrorException e, HttpServletRequest request){
		ExceptionResponse errors = new ExceptionResponse();
		errors.setStatus_code(HttpStatus.INTERNAL_SERVER_ERROR.value());
		errors.setMessage("Internal Server Error");
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errors);
	}	
}
