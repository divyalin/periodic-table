package com.divyalin.periodic_table.model;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


/**
 * Test class for element Response
 *
 * <p>
 * This class tests whether the element response stores
 * the appropriate value based on the logic added in the constructor
 * </p>
 *
 * @author Divyalin
 * @version 1.0
 */
class ElementResponseTest {

    /**
     * Tests ElementResponse Constructor Logic
     * <p>
     * This method tests whether the Constructor Logic of
     * ElementResponse class works as expected.
     * </p>
     */
    @Test
    void getAlternateName() {
        ElementResponse elementResponse1 = new ElementResponse("Element125", 125, "n/a", "n/a");
        ElementResponse elementResponse2 = new ElementResponse("Element126", 126, "alternateName", "n/a");
        ElementResponse elementResponse3 = new ElementResponse("Element127", 127, "n/a", "alternate1, alternate2");
        assertEquals("None", elementResponse1.getAlternateName());
        assertEquals("alternateName", elementResponse2.getAlternateName());
        assertEquals("alternate1, alternate2", elementResponse3.getAlternateName());
    }
}