package com.divyalin.periodic_table.bootstrap;

import com.divyalin.periodic_table.model.Element;
import com.divyalin.periodic_table.repository.ElementRepository;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.io.InputStream;
import java.util.List;

/**
 * The class for loading data into the database after application startup
 * <p>
 * Once the application starts up successfully, the run method below is executed.
 * It stores the json data retrieved from resources/data/periodic_table.json into the database
 * </p>
 *
 * @author Divyalin
 * @version 1.0
 */
@Component
@AllArgsConstructor
public class ElementLoader implements CommandLineRunner {

    private final ElementRepository repository;

    private final ObjectMapper mapper;

    /**
     * Method that de-serializes element data from json
     * and stores in the database
     */
    @Override
    public void run(String... args) throws Exception {
        TypeReference<List<Element>> typeRef = new TypeReference<>() {};
        try (InputStream inputStream = getClass().getResourceAsStream("/data/periodic_table.json")) {
            List<Element> elements = mapper.readValue(inputStream, typeRef);
            repository.saveAll(elements);
        }
    }
}

