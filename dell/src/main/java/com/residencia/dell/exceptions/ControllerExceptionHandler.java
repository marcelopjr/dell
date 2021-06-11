package com.residencia.dell.exceptions;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;


@ControllerAdvice
public class ControllerExceptionHandler extends ResponseEntityExceptionHandler{

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request){
		
		List<String> lErrors = new ArrayList<>();
		
		for (FieldError error : ex.getBindingResult().getFieldErrors()) {
			lErrors.add(error.getField() + " " + error.getDefaultMessage());
		}
		
		ErroResposta erroResposta = new ErroResposta(status.value(), "Verifique os Campos", LocalDateTime.now(), lErrors);
		
		return super.handleExceptionInternal(ex, erroResposta, headers, status, request);
	}
		
}
