package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;


@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AddressException.class)
	public ResponseEntity<ExceptionDTO> studentExceptionHandler(AddressException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CartException.class)
	public ResponseEntity<ExceptionDTO> studentExceptionHandler(CartException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(CustomerException.class)
	public ResponseEntity<ExceptionDTO> studentExceptionHandler(CustomerException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(OrderException.class)
	public ResponseEntity<ExceptionDTO> studentExceptionHandler(OrderException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(ProductException.class)
	public ResponseEntity<ExceptionDTO> studentExceptionHandler(ProductException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
//	==========================================================================
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<ExceptionDTO> validationExceptionHandler(MethodArgumentNotValidException e){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(e.getBindingResult().getFieldError().getDefaultMessage());
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	@ExceptionHandler(NullPointerException.class)
	public ResponseEntity<ExceptionDTO> nullPointerExceptionHandler(NullPointerException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	
	
	
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<ExceptionDTO> noHandlerFoundException(NoHandlerFoundException e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<ExceptionDTO> masterExceptionHandler(Exception e, WebRequest wr){
		
		ExceptionDTO err=new ExceptionDTO();
		err.setDateAndTime(LocalDateTime.now());
		err.setMessage(e.getMessage());
		err.setDesc(wr.getDescription(false));
		
		return new ResponseEntity<ExceptionDTO>(err, HttpStatus.BAD_REQUEST);
		
	}

}
