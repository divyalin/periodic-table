package com.divyalin.periodic_table.exception;

import com.divyalin.periodic_table.model.ErrorResponse;
import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Global exception handler
 *
 * @author Divyalin
 * @version 1.0
 */
@RestControllerAdvice
public class ElementsExceptionHandler {

    /**
     * Exception handler for type ElementNotFoundException
     *
     * @param exception the ElementNotFoundException object
     * @return the response entity containing exception message and status code
     */
    @ExceptionHandler(ElementNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleElementNotFound(ElementNotFoundException exception) {
        ErrorResponse error = new ErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                exception.getMessage(),
                LocalDateTime.now()
        );
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    /**
     * Exception handler for type ConstraintViolationException
     * <p>
     * Anytime a constraint is violated while adding or retrieving data
     * from the database, this exception is thrown.
     * </p>
     *
     * @param exception the ConstraintViolationException object
     * @return the response entity containing exception message and status code
     */
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Map<String, String>> handleConstraintViolation(ConstraintViolationException exception) {
        Map<String, String> errors = new HashMap<>();

        exception.getConstraintViolations().forEach(violation -> {
            String field = violation.getPropertyPath().toString();
            String message = violation.getMessage();
            errors.put(field, message);
        });

        return ResponseEntity.badRequest().body(errors);
    }
}
