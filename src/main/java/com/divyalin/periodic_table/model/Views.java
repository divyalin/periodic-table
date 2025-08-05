package com.divyalin.periodic_table.model;

/**
 * The marker interface for filtering json views.
 *
 * <p>
 * Used in conjunction with @JsonView annotation
 * in response object and controller method
 * </p>
 *
 * @author Divyalin
 * @version 1.0
 */
public interface Views {
    interface Basic {
    }

    interface Detailed extends Basic {
    }
}
