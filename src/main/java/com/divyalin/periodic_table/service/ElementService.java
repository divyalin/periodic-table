package com.divyalin.periodic_table.service;

import com.divyalin.periodic_table.model.ElementResponse;

import java.util.List;

/**
 * The service interface for periodic-table elements processing
 *
 * @author Divyalin
 * @version 1.0
 */
public interface ElementService {

    /**
     * Returns name and atomic number of all elements stored in the db.
     *
     * @return all elements saved in db.
     */
    List<ElementResponse> getAllElements();

    /**
     * Returns name, atomic number and alternate names of element with the given atomic Number
     *
     * @param atomicNumber atomic number of the element
     * @return element matching the atomic number in the input.
     */
    ElementResponse getElementByAtomicNumber(int atomicNumber);

    /**
     * Returns name and atomic number of elements belonging to the given group
     *
     * @param groupNumber group number for which elements need to be found
     * @return all elements matching the given groupNumber.
     */
    List<ElementResponse> getElementsByGroup(int groupNumber);
}
