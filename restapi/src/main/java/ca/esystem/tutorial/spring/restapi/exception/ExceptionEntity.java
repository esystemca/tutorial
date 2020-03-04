package ca.esystem.tutorial.spring.restapi.exception;

import java.util.Calendar;
import java.util.Date;

public class ExceptionEntity {
	private String status;
	private String error;
	private String message;
	private Date timestamp = Calendar.getInstance().getTime();
	private String path;
	
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Date getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}
	public String getPath() {
		return path;
	}
	public void setPath(String path) {
		this.path = path;
	}
	
	public static final class ExceptionEntityBuilder {
		
		private String status;
		private String error;
		private String message;
		private String path;
		
		public ExceptionEntityBuilder withStatus(String status) {
			this.status = status;
		    return this;
		}
		
		
		public ExceptionEntityBuilder withError(String error) {
			this.error = error;
			return this;
		}
		
		public ExceptionEntityBuilder withMessage(String message) {
			this.message = message;
			return this;
		}
		
		public ExceptionEntityBuilder withPath(String path) {
			this.path = path;
			return this;
		}
		
		public ExceptionEntity build() {
			final ExceptionEntity exceptionEntity = new ExceptionEntity();
			exceptionEntity.setStatus(this.status);
			exceptionEntity.setError(this.error);
			exceptionEntity.setMessage(this.message);
			exceptionEntity.setPath(this.path);
			return exceptionEntity;
		}
		
	}
}
