package kodlama.io.Devs;

import java.util.HashMap;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.orm.jpa.JpaObjectRetrievalFailureException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import kodlama.io.Devs.core.exceptions.BusinessException;
import kodlama.io.Devs.core.exceptions.JpaObjectRetrievalProblemDetails;
import kodlama.io.Devs.core.exceptions.NullPointerProblemDetails;
import kodlama.io.Devs.core.exceptions.ProblemDetails;
import kodlama.io.Devs.core.exceptions.ValidationProblemDetails;

@SpringBootApplication
@RestControllerAdvice
public class DevsApplication {

	public static void main(String[] args) {
		SpringApplication.run(DevsApplication.class, args);
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ProblemDetails handleBusinessException(BusinessException businessException) {
		ProblemDetails problemDetails = new ProblemDetails();
		problemDetails.setMessage(businessException.getMessage());
		
		return problemDetails;
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public ValidationProblemDetails handleValidationException(MethodArgumentNotValidException methodArgumentNotValidException) {
		ValidationProblemDetails validationProblemDetails = new ValidationProblemDetails();
		validationProblemDetails.setMessage("Validation Exception");
		
		validationProblemDetails.setValidationErrors(new HashMap<String, String>());
		
		for(FieldError fieldError : methodArgumentNotValidException.getBindingResult().getFieldErrors()) {
			validationProblemDetails.getValidationErrors().put(fieldError.getField(), fieldError.getDefaultMessage());
		}
		
		return validationProblemDetails;
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public NullPointerProblemDetails handleNullPointerException(NullPointerException nullPointerException) {
		NullPointerProblemDetails problemDetails = new NullPointerProblemDetails();
		problemDetails.setMessage(nullPointerException.getMessage());
		
		return problemDetails;
	}
	
	@ExceptionHandler
	@ResponseStatus(code = HttpStatus.BAD_REQUEST)
	public JpaObjectRetrievalProblemDetails handleNullPointerException(JpaObjectRetrievalFailureException jpaObjectRetrievalFailureException) {
		JpaObjectRetrievalProblemDetails problemDetails = new JpaObjectRetrievalProblemDetails();
		problemDetails.setMessage(jpaObjectRetrievalFailureException.getMessage());
		
		return problemDetails;
	}
	
	
	@Bean
	public ModelMapper getModelMapper() {
		return new ModelMapper();
	}

}
