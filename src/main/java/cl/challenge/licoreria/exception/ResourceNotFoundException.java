package cl.challenge.licoreria.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import lombok.Getter;

@Getter
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends RuntimeException {

	private static final long serialVersionUID = -4294095472220792615L;
	
	private String message;
	
	public ResourceNotFoundException(String message) {
		super();
		this.message = message;
	}

}
