package info.product.productmanagement.advisor;



import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import info.product.productmanagement.exception.BusinessException;

import org.hibernate.exception.ConstraintViolationException;


  @ControllerAdvice 
  public class ControllerAdvisor extends ResponseEntityExceptionHandler {
  
		/*
		 * @ExceptionHandler(ConstraintViolationException.class) public
		 * ResponseEntity<String>
		 * handleConstraintViolationException(ConstraintViolationException
		 * constraintViolationException) { return new
		 * ResponseEntity<String>("You have dependencies! please delete it first "
		 * ,HttpStatus.BAD_REQUEST); }
		 */
	
	  @ExceptionHandler(BusinessException.class) 
	  public ResponseEntity<String> handleRuntimeException(BusinessException businessException)
	  { 
		  return new ResponseEntity<String>(businessException.getErrorMessage(), HttpStatus.BAD_REQUEST); 
	  }
	 
@Override
	protected ResponseEntity<Object> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		return new ResponseEntity<Object>("please change yout http method type", HttpStatus.BAD_REQUEST);
		
	} 
  
  }
 
