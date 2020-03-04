package ca.esystem.tutorial.spring.restapi.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	private ResponseEntity<ExceptionEntity> error(final Exception exception, final HttpStatus httpStatus,String path) {
		ExceptionEntity exceptionEntity = new ExceptionEntity.ExceptionEntityBuilder()
				.withStatus(httpStatus.value()+"").withMessage(exception.getLocalizedMessage())
				.withError(exception.getClass().getName())
				.withPath(path)
				.build();
		return new ResponseEntity<ExceptionEntity>(exceptionEntity, httpStatus);
	}
	
	@ExceptionHandler(ConflictException.class)
	public ResponseEntity<ExceptionEntity> handlerConflict(final ConflictException e,HttpServletRequest request) {
		return error(e, HttpStatus.CONFLICT,request.getRequestURI());
	}
	
	@ExceptionHandler(NotFoundException.class)
	public ResponseEntity<ExceptionEntity> handlerConflict(final NotFoundException e,HttpServletRequest request) {
		return error(e, HttpStatus.NOT_FOUND,request.getRequestURI());
	}	
}

