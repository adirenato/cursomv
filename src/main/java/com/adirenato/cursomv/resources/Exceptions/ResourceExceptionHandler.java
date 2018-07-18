package com.adirenato.cursomv.resources.Exceptions;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.adirenato.cursomv.services.exceptions.ObjectNotFoundException;
import com.adirenato.cursomv.services.exceptions.ConstraintException;

@ControllerAdvice
public class ResourceExceptionHandler {
     //classe manipuladora de error 
	 //assinatura padrão do metodo 
	@ExceptionHandler(ObjectNotFoundException.class)
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request){
    	   StandardError error = new StandardError(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
    	   return  ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
     }
	
	@ExceptionHandler(ConstraintException.class)
	public ResponseEntity<StandardError> ConstraintException(ConstraintException e, HttpServletRequest request){
    	   StandardError error = new StandardError(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
    	   return  ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
     }
}
