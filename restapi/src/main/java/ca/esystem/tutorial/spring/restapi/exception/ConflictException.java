package ca.esystem.tutorial.spring.restapi.exception;

public class ConflictException extends RuntimeException {

	private static final long serialVersionUID = -6203329145306395813L;
	
	public ConflictException(String message) {
		super(message);
	}	
}

