package ca.esystem.tutorial.spring.restapi.exception;

public class NotFoundException extends RuntimeException {
	
	private static final long serialVersionUID = -6440167617991497067L;
	
	public NotFoundException(String message) {
		super(message);
	}
}

