package com.divyalin.periodic_table.exception;

/**
 * Custom exception class for processing 'Element Not Found' exceptions
 *
 * @author Divyalin
 * @version 1.0
 */
public class ElementNotFoundException extends RuntimeException {

    /**
     * Constructor which takes exception message as parameter
     *
     * @param message the exception message
     */
    public ElementNotFoundException(String message) {
        super(message);
    }
}
