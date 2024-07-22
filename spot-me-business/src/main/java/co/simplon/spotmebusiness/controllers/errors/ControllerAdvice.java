package co.simplon.spotmebusiness.controllers.errors;

import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ControllerAdvice extends ResponseEntityExceptionHandler {

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
	    MethodArgumentNotValidException ex, HttpHeaders headers,
	    HttpStatusCode status, WebRequest request) {
	List<FieldError> errors = ex.getFieldErrors();
	CustomErrors customErrors = new CustomErrors();
	for (FieldError error : errors) {
	    String fieldName = error.getField();
	    String code = error.getCode();
	    customErrors.addFieldError(fieldName, code);
	}
	List<ObjectError> globalErrors = ex.getGlobalErrors();
	for (ObjectError error : globalErrors) {
	    String code = error.getCode();
	    customErrors.addGlobalError(code);
	}
	return handleExceptionInternal(ex, customErrors, headers, status,
		request);
    }

    @Override
    protected ResponseEntity<Object> handleExceptionInternal(Exception ex,
	    Object body, HttpHeaders headers, HttpStatusCode statusCode,
	    WebRequest request) {
	return super.handleExceptionInternal(ex, body, headers, statusCode,
		request);
    }

}
