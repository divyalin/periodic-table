package com.divyalin.periodic_table.controller;

import com.divyalin.periodic_table.model.ElementResponse;
import com.divyalin.periodic_table.model.Views;
import com.divyalin.periodic_table.service.ElementService;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * The controller class for periodic table elements processing
 *
 * <p>
 * The client requests are received and sent for further processing
 * from this class. It also returns the results.
 * </p>
 *
 * @author Divyalin
 * @version 1.0
 */
@Validated
@RestController
@RequestMapping("/api/v1/elements")
@AllArgsConstructor
public class ElementController {

    private final ElementService service;

    /**
     * Accepts requests for retrieving all elements from the database.
     * <p>
     * Accepts no parameter but returns the list of all elements.
     * Only name and atomic number of each element is returned.
     * </p>
     *
     * @return the response entity containing the list of elements and status code
     */
    @GetMapping("")
    @JsonView(Views.Basic.class)
    public ResponseEntity<List<ElementResponse>> getAllElements() {
        List<ElementResponse> responseList = service.getAllElements();
        return ResponseEntity.ok(responseList);
    }

    /**
     * Accepts requests for finding elements based on atomicNumber.
     * <p>
     * Accepts atomic number as input for finding corresponding element from db.
     * Returns response containing element name, atomicNumber and alternate names along with status code
     * </p>
     *
     * @param atomicNumber the atomic number of the element to be retrieved
     * @return the response entity containing element details and status code
     */
    @GetMapping("/{atomicNumber}")
    public ResponseEntity<ElementResponse> getByAtomicNumber(@PathVariable int atomicNumber) {
        ElementResponse response = service.getElementByAtomicNumber(atomicNumber);
        return ResponseEntity.ok(response);
    }

    /**
     * Accepts requests for finding elements based on group number.
     * <p>
     * Accepts group number as input for finding corresponding elements from db.
     * Returns response containing element name and atomic number along with status code.
     * Validates whether the group number is between 1 and 18.
     * </p>
     *
     * @param groupNumber the group number of the elements to be retrieved
     * @return the response entity containing the list of element name, atomic number and status code
     */
    @GetMapping("/group/{groupNumber}")
    @JsonView(Views.Basic.class)
    public ResponseEntity<List<ElementResponse>> getElementsByGroup(
            @PathVariable
            @Min(value = 1, message = "Group number must be at least 1.")
            @Max(value = 18, message = "Group number must be at most 18.")
            int groupNumber) {

        List<ElementResponse> elements = service.getElementsByGroup(groupNumber);
        return ResponseEntity.ok(elements);
    }
}
