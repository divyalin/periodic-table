package com.divyalin.periodic_table.controller;

import com.divyalin.periodic_table.exception.ElementNotFoundException;
import com.divyalin.periodic_table.model.ElementResponse;
import com.divyalin.periodic_table.service.ElementService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

/**
 * Test class for element controller
 *
 * <p>
 * This class tests whether the api calls to ElementController are accepted
 * and appropriate response returned as expected
 * </p>
 *
 * @author Divyalin
 * @version 1.0
 */
@WebMvcTest(ElementController.class)
class ElementControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockitoBean
    private ElementService elementService;

    private static final Integer ATOMIC_NUMBER_1 = 125;
    private static final Integer ATOMIC_NUMBER_2 = 126;
    private static final Integer ATOMIC_NUMBER_3 = 127;
    private static final String ELEMENT_NAME_1 = "Element125";
    private static final String ELEMENT_NAME_2 = "Element126";
    private static final String ELEMENT_NAME_3 = "Element127";
    private static final String INVALID_INPUT = "Invalid";
    private static final Integer GROUP_NUMBER = 5;
    private static final String BASE_URL = "/api/v1/elements";
    private static final String NOT_FOUND_MESSAGE = "No element found with atomic number ";

    /**
     * Tests getAllElements method in controller
     * <p>
     * This method tests whether the getAllElements functionality
     * calls the service class with the appropriate content and
     * returns all the elements as expected.
     * </p>
     */
    @Test
    void testGetAllElements() throws Exception {

        when(elementService.getAllElements()).thenReturn(elementResponseList());

        mockMvc.perform(get(BASE_URL))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(ELEMENT_NAME_1))
                .andExpect(jsonPath("$[1].atomicNumber").value(ATOMIC_NUMBER_2));
    }

    /**
     * Tests success scenario in getElementByAtomicNumber method in controller
     * <p>
     * This method tests whether the find by atomicNumber functionality
     * calls the service class with the appropriate content and
     * returns the expected result when an element exists for the given
     * atomicNumber.
     * </p>
     */
    @Test
    void testGetByAtomicNumber() throws Exception {
        ElementResponse mockElement = new ElementResponse(ELEMENT_NAME_1, ATOMIC_NUMBER_1, "n/a", "n/a");

        when(elementService.getElementByAtomicNumber(1)).thenReturn(mockElement);

        mockMvc.perform(get(BASE_URL + "/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value(ELEMENT_NAME_1))
                .andExpect(jsonPath("$.alternateName").value("None"));
    }

    /**
     * Tests exception scenario in getElementByAtomicNumber method in controller
     * <p>
     * This method tests whether the find by atomic number functionality
     * calls the service class and returns the ElementNotFound exception
     * when an element does not exist for the given atomic number.
     * </p>
     */
    @Test
    void testGetByAtomicNumber_returnsNotFoundException() throws Exception {
        String errorMessage = NOT_FOUND_MESSAGE + ATOMIC_NUMBER_1;

        when(elementService.getElementByAtomicNumber(ATOMIC_NUMBER_1))
                .thenThrow(new ElementNotFoundException(errorMessage));

        mockMvc.perform(get(BASE_URL + "/" + ATOMIC_NUMBER_1))
                .andExpect(status().isNotFound())
                .andExpect(content().string(containsString(errorMessage)));
    }

    /**
     * Tests exception scenario in getElementByAtomicNumber method in controller
     * <p>
     * This method tests whether the find by atomic number functionality
     * returns the expected exception when the input type is wrong.
     * </p>
     */
    @Test
    void testGetByAtomicNumber_returnsBadRequestForWrongInput() throws Exception {
        mockMvc.perform(get(BASE_URL + "/" + INVALID_INPUT))
                .andExpect(status().isBadRequest());
    }

    /**
     * Tests success scenario in getElementsByGroup method in controller
     * <p>
     * This method tests whether the find by group number functionality
     * calls the service class with the appropriate content and
     * returns the list of elements belonging to that group number
     * </p>
     */
    @Test
    void testGetElementsByGroup() throws Exception {
        List<ElementResponse> mockList = elementResponseList();

        when(elementService.getElementsByGroup(GROUP_NUMBER)).thenReturn(mockList);

        mockMvc.perform(get(BASE_URL + "/group/" + GROUP_NUMBER))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value(ELEMENT_NAME_1))
                .andExpect(jsonPath("$[1].name").value(ELEMENT_NAME_2))
                .andExpect(jsonPath("$[2].atomicNumber").value(ATOMIC_NUMBER_3));
    }

    /**
     * Tests exception scenario in getElementByGroup method in controller
     * <p>
     * This method tests whether the find by group block functionality
     * returns the validation exception when the group number is below min
     * </p>
     */
    @Test
    void testGetElementsByGroup_failsValidationForGroupNumberBelowMin() throws Exception {
        mockMvc.perform(get(BASE_URL + "/group/0"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Group number must be at least 1.")));
    }

    /**
     * Tests exception scenario in getElementByGroup method in controller
     * <p>
     * This method tests whether the find by group block functionality
     * returns the validation exception when the group number is above max
     * </p>
     */
    @Test
    void testGetElementsByGroup_failsValidationForGroupNumberAboveMax() throws Exception {
        mockMvc.perform(get(BASE_URL + "/group/19"))
                .andExpect(status().isBadRequest())
                .andExpect(content().string(containsString("Group number must be at most 18.")));
    }

    /**
     * Tests exception scenario in getElementByGroup method in controller
     * <p>
     * This method tests whether the find by group block functionality
     * returns the bad request exception when the group number is invalid
     * </p>
     */
    @Test
    void testGetElementsByGroup_returnsBadRequestForWrongInput() throws Exception {
        mockMvc.perform(get(BASE_URL + "/group/" + INVALID_INPUT))
                .andExpect(status().isBadRequest());
    }

    /**
     * Utility method that returns a list of ElementResponses
     */
    private static List<ElementResponse> elementResponseList() {
        ElementResponse elementResponse1 = new ElementResponse(ELEMENT_NAME_1, ATOMIC_NUMBER_1);
        ElementResponse elementResponse2 = new ElementResponse(ELEMENT_NAME_2, ATOMIC_NUMBER_2);
        ElementResponse elementResponse3 = new ElementResponse(ELEMENT_NAME_3, ATOMIC_NUMBER_3);
        return List.of(elementResponse1, elementResponse2, elementResponse3);
    }
}