package com.divyalin.periodic_table.service;

import com.divyalin.periodic_table.exception.ElementNotFoundException;
import com.divyalin.periodic_table.model.Element;
import com.divyalin.periodic_table.model.ElementResponse;
import com.divyalin.periodic_table.repository.ElementRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The service class that implements periodic table processing
 *
 * <p>
 * The periodic table element details are processed here.
 * It retrieves information based on the input.
 * </p>
 *
 * @author Divyalin
 * @version 1.0
 */
@Service
@AllArgsConstructor
public class ElementServiceImpl implements ElementService {

    private final ElementRepository repository;

    /**
     * {@inheritDoc}
     */
    public List<ElementResponse> getAllElements() {
        return repository.findAll().stream()
                .map(e -> new ElementResponse(e.getName(), e.getAtomicNumber()))
                .sorted(Comparator.comparingInt(ElementResponse::getAtomicNumber))
                .collect(Collectors.toList());
    }

    /**
     * {@inheritDoc}
     * <p>
     * If no matching element is found, it sends back an ElementNotFoundException
     * with the appropriate message.
     * </p>
     */
    public ElementResponse getElementByAtomicNumber(int atomicNumber) {
        Element element = repository.findById(atomicNumber)
                .orElseThrow(() -> new ElementNotFoundException("Element with atomic number " + atomicNumber + " not found"));

        return new ElementResponse(
                element.getName(),
                element.getAtomicNumber(),
                element.getAlternativeName(),
                element.getAlternativeNames()
        );
    }

    /**
     * {@inheritDoc}
     * <p>
     * If no matching element is found, it sends back an ElementNotFoundException
     * with the appropriate message.
     * </p>
     */
    public List<ElementResponse> getElementsByGroup(int groupNumber) {
        List<Element> elementGroup = repository.findByGroupNumber("group " + groupNumber);

        if (elementGroup.isEmpty()) {
            throw new ElementNotFoundException("No elements found for group " + groupNumber);
        }

        return elementGroup.stream().map(e -> new ElementResponse(e.getName(), e.getAtomicNumber()))
                .sorted(Comparator.comparingInt(ElementResponse::getAtomicNumber))
                .collect(Collectors.toList());
    }
}
