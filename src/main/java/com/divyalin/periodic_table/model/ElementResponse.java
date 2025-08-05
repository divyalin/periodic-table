package com.divyalin.periodic_table.model;

import com.fasterxml.jackson.annotation.JsonView;
import lombok.Data;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * The response object for storing element data
 * <p>
 * Depending on the marker interfaces used, only certain fields
 * are serialized onto the json view
 * </p>
 *
 * @author Divyalin
 * @version 1.0
 */
@Data
public class ElementResponse {

    @JsonView(Views.Basic.class)
    private String name;

    @JsonView(Views.Basic.class)
    private Integer atomicNumber;

    @JsonView(Views.Detailed.class)
    private String alternateName;

    public ElementResponse(String name, Integer atomicNumber) {
        this.name = name;
        this.atomicNumber = atomicNumber;
    }

    public ElementResponse(String name, Integer atomicNumber, String dbAlternateName, String dbAlternateNames) {
        this.name = name;
        this.atomicNumber = atomicNumber;

        boolean isAltNameValid = dbAlternateName != null && !dbAlternateName.equalsIgnoreCase("n/a");
        boolean isAltNamesValid = dbAlternateNames != null && !dbAlternateNames.equalsIgnoreCase("n/a");

        if (isAltNamesValid) {
            List<String> namesList = Arrays.stream(dbAlternateNames.split(","))
                    .map(String::trim)
                    .filter(s -> !s.equalsIgnoreCase("n/a") && !s.isEmpty())
                    .collect(Collectors.toList());
            this.alternateName = String.join(", ", namesList);
        } else if (isAltNameValid) {
            this.alternateName = dbAlternateName.trim();
        } else {
            this.alternateName = "None";
        }
    }
}
