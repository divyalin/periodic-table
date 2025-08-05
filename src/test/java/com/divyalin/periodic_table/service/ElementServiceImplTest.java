package com.divyalin.periodic_table.service;

import com.divyalin.periodic_table.exception.ElementNotFoundException;
import com.divyalin.periodic_table.model.Element;
import com.divyalin.periodic_table.model.ElementResponse;
import com.divyalin.periodic_table.repository.ElementRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

/**
 * Test class for element service
 *
 * <p>
 * This class tests whether the element details are processed
 * as expected
 * </p>
 *
 * @author Divyalin
 * @version 1.0
 */
@ExtendWith(MockitoExtension.class)
class ElementServiceImplTest {

    @Mock
    private ElementRepository repository;

    @InjectMocks
    private ElementServiceImpl service;

    private static final Integer ATOMIC_NUMBER_1 = 125;
    private static final Integer ATOMIC_NUMBER_2 = 126;
    private static final Integer ATOMIC_NUMBER_3 = 127;
    private static final String ELEMENT_NAME_1 = "Element125";
    private static final String ELEMENT_NAME_2 = "Element126";
    private static final String ELEMENT_NAME_3 = "Element127";
    private static final String GROUP_NUMBER = "group 5";

    /**
     * Tests getAllElements method.
     * <p>
     * This method tests whether the getAllElements method
     * calls the repository class and returns all the elements
     * as expected.
     * </p>
     */
    @Test
    void testGetAllElements() {
        List<Element> elements = getListOfElements();

        when(repository.findAll()).thenReturn(elements);

        List<ElementResponse> result = service.getAllElements();

        assertEquals(3, result.size());
        assertEquals(ELEMENT_NAME_1, result.get(0).getName());
        assertEquals(ATOMIC_NUMBER_2, result.get(1).getAtomicNumber());
        assertEquals(ELEMENT_NAME_3, result.get(2).getName());
    }

    /**
     * Tests success scenario of getElementByAtomicNumber method.
     *
     * <p>
     * This method tests whether the getElementByAtomicNumber
     * calls the repository class and returns the matching
     * element as expected.
     * </p>
     */
    @Test
    void testGetElementByAtomicNumber() {
        Element element = Element.builder()
                .name(ELEMENT_NAME_1)
                .atomicNumber(ATOMIC_NUMBER_1)
                .alternativeName("n/a")
                .alternativeNames("n/a")
                .build();

        when(repository.findById(ATOMIC_NUMBER_1)).thenReturn(Optional.of(element));

        ElementResponse response = service.getElementByAtomicNumber(ATOMIC_NUMBER_1);

        assertEquals(ELEMENT_NAME_1, response.getName());
        assertEquals("None", response.getAlternateName());
    }

    /**
     * Tests failure scenario of getElementByAtomicNumber method.
     *
     * <p>
     * This method tests whether the getElementByAtomicNumber
     * throws ElementNotFoundException if the atomic number
     * doesn't match any row in the db table.
     * </p>
     */
    @Test
    void testGetElementByAtomicNumber_throwsException() {
        when(repository.findById(ATOMIC_NUMBER_3)).thenReturn(Optional.empty());

        ElementNotFoundException exception = assertThrows(
                ElementNotFoundException.class,
                () -> service.getElementByAtomicNumber(ATOMIC_NUMBER_3)
        );

        assertEquals("Element with atomic number " + ATOMIC_NUMBER_3 + " not found", exception.getMessage());
    }

    /**
     * Tests success scenario of getElementByGroup method.
     *
     * <p>
     * This method tests whether the getElementByGroup
     * calls the repository class and returns all the matching
     * elements as expected.
     * </p>
     */
    @Test
    void testGetElementsByGroup() {
        when(repository.findByGroupNumber(GROUP_NUMBER)).thenReturn(getListOfElements());

        List<ElementResponse> result = service.getElementsByGroup(5);

        assertEquals(3, result.size());
        assertEquals(ELEMENT_NAME_1, result.get(0).getName());
        assertEquals(ELEMENT_NAME_2, result.get(1).getName());
        assertEquals(ELEMENT_NAME_3, result.get(2).getName());
    }

    /**
     * Tests failure scenario of getElementsByGroup method.
     *
     * <p>
     * This method tests whether the getElementsByGroup
     * throws ElementNotFoundException if the group number
     * doesn't match any row in the db table.
     * </p>
     */
    @Test
    void testGetElementsByGroup_throwsExceptionForNoGroup() {
        when(repository.findByGroupNumber(GROUP_NUMBER)).thenReturn(List.of());

        ElementNotFoundException exception = assertThrows(
                ElementNotFoundException.class,
                () -> service.getElementsByGroup(5)
        );

        assertEquals("No elements found for " + GROUP_NUMBER, exception.getMessage());
    }

    private static List<Element> getListOfElements() {
        return List.of(
                Element.builder().name(ELEMENT_NAME_1).atomicNumber(ATOMIC_NUMBER_1).build(),
                Element.builder().name(ELEMENT_NAME_2).atomicNumber(ATOMIC_NUMBER_2).build(),
                Element.builder().name(ELEMENT_NAME_3).atomicNumber(ATOMIC_NUMBER_3).build()
        );
    }
}