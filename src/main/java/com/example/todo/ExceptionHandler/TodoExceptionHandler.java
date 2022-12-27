package com.example.todo.ExceptionHandler;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.example.todo.Model.ErrorDetails;

//@RestControllerAdvice
//public class TodoExceptionHandler extends ResponseEntityExceptionHandler{
//	
//	@Override
//	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
//			HttpHeaders headers, HttpStatus status, WebRequest request) {
//		
//		Map<String, String> errors = new HashMap<>();
//		ex.getBindingResult().getAllErrors().forEach((error) ->{
//			
//			String fieldName = ((FieldError) error).getField();
//			String message = error.getDefaultMessage();
//			errors.put(fieldName, message);
//		});
//		return new ResponseEntity<Object>(errors, HttpStatus.BAD_REQUEST);
//	}
//}

@RestControllerAdvice
public class TodoExceptionHandler {
	@ExceptionHandler({MethodArgumentNotValidException.class})
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public ErrorDetails handleValidationError(MethodArgumentNotValidException exception) {

		
	    List<String> errors = new ArrayList<>();
	    if (exception.hasErrors()) {
	    	Consumer<ObjectError> addToErrorsList=(x)->{errors.add(x.getDefaultMessage());};
	    	exception.getAllErrors().stream().forEach(addToErrorsList);
	    }
	    ErrorDetails errorDetails=new ErrorDetails(new Date(), errors);
	    return errorDetails;
	}
	
//	@ExceptionHandler({NoSuchElementException.class})
//	@ResponseStatus(HttpStatus.NOT_FOUND)
//	public ErrorDetails handleNoSuchElementException(NoSuchElementException exception) {
//		List<String> errors = new ArrayList<>();
//		errors.add(exception.getMessage());
//	    ErrorDetails errorDetails=new ErrorDetails(new Date(),errors);
//	    return errorDetails;
//	}
	
//	@ExceptionHandler({Exception.class})
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	public ErrorDetails handleNoSuchElementException(Exception exception) {
//		List<String> errors = new ArrayList<>();
//		errors.add(exception.getMessage());
//	    ErrorDetails errorDetails=new ErrorDetails(new Date(), errors);
//	    return errorDetails;
//	}
}
