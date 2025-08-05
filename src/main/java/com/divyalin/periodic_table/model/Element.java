package com.divyalin.periodic_table.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The model class for storing element data
 *
 * @author Divyalin
 * @version 1.0
 */
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "T_ELEMENT")
public class Element {

    @Id
    @JsonProperty("atomic_number")
    @Column(name = "atomic_number")
    private Integer atomicNumber;

    @JsonProperty("allotropes")
    @Column(name = "allotropes")
    private String allotropes;

    @JsonProperty("alternative_name")
    @Column(name = "alternative_name")
    private String alternativeName;

    @JsonProperty("alternative_names")
    @Column(name = "alternative_names")
    private String alternativeNames;

    @JsonProperty("appearance")
    @Column(name = "appearance")
    private String appearance;

    @JsonProperty("at_t_(k)")
    @Column(name = "at_t_(k)")
    private String atTK;

    @JsonProperty("atomic_radius")
    @Column(name = "atomic_radius")
    private String atomicRadius;

    @JsonProperty("atomic_weight")
    @Column(name = "atomic_weight")
    private Double atomicWeight;

    @JsonProperty("band_gap")
    @Column(name = "band_gap")
    private String bandGap;

    @JsonProperty("boiling_point")
    @Column(name = "boiling_point")
    private String boilingPoint;

    @JsonProperty("brinell_hardness")
    @Column(name = "brinell_hardness")
    private String brinellHardness;

    @JsonProperty("bulk_modulus")
    @Column(name = "bulk_modulus")
    private String bulkModulus;

    @JsonProperty("cas_number")
    @Column(name = "cas_number")
    private String casNumber;

    @JsonProperty("color")
    @Column(name = "color")
    private String color;

    @JsonProperty("covalent_radius")
    @Column(name = "covalent_radius")
    private String covalentRadius;

    @JsonProperty("critical_point")
    @Column(name = "critical_point")
    private String criticalPoint;

    @JsonProperty("crystal_structure")
    @Column(name = "crystal_structure")
    private String crystalStructure;

    @JsonProperty("curie_point")
    @Column(name = "curie_point")
    private String curiePoint;

    @JsonProperty("density_at_stp")
    @Column(name = "density_at_stp")
    private String densityAtStp;

    @JsonProperty("density_near_rt")
    @Column(name = "density_near_rt")
    private String densityNearRt;

    @JsonProperty("density_when_liquid_at_mp")
    @Column(name = "density_when_liquid_at_mp")
    private String densityWhenLiquidAtMp;

    @JsonProperty("discovery")
    @Column(name = "discovery")
    private String discovery;

    @JsonProperty("discovery_and_first_isolation")
    @Column(name = "discovery_and_first_isolation")
    private String discoveryAndFirstIsolation;

    @JsonProperty("electrical_resistivity")
    @Column(name = "electrical_resistivity")
    private String electricalResistivity;

    @JsonProperty("electron_configuration")
    @Column(name = "electron_configuration")
    private String electronConfiguration;

    @JsonProperty("electronegativity")
    @Column(name = "electronegativity")
    private String electronegativity;

    @JsonProperty("element_category")
    @Column(name = "element_category")
    private String elementCategory;

    @JsonProperty("first_isolation")
    @Column(name = "first_isolation")
    private String firstIsolation;

    @JsonProperty("group_block")
    @Column(name = "group_block")
    private String groupBlock;

    @JsonProperty("heat_of_fusion")
    @Column(name = "heat_of_fusion")
    private String heatOfFusion;

    @JsonProperty("heat_of_vaporisation")
    @Column(name = "heat_of_vaporisation")
    private String heatOfVaporisation;

    @JsonProperty("heat_of_vaporization")
    @Column(name = "heat_of_vaporization")
    private String heatOfVaporization;

    @JsonProperty("ionisation_energies")
    @Column(name = "ionisation_energies")
    private String ionisationEnergies;

    @JsonProperty("ionization_energies")
    @Column(name = "ionization_energies")
    private String ionizationEnergies;

    @JsonProperty("iso")
    @Column(name = "iso", columnDefinition = "TEXT")
    private String iso;

    @JsonProperty("magnetic_ordering")
    @Column(name = "magnetic_ordering")
    private String magneticOrdering;

    @JsonProperty("melting_point")
    @Column(name = "melting_point")
    private String meltingPoint;

    @JsonProperty("mohs_hardness")
    @Column(name = "mohs_hardness")
    private String mohsHardness;

    @JsonProperty("molar_heat_capacity")
    @Column(name = "molar_heat_capacity")
    private String molarHeatCapacity;

    @JsonProperty("molar_volume")
    @Column(name = "molar_volume")
    private String molarVolume;

    @JsonProperty("name")
    @Column(name = "name")
    private String name;

    @JsonProperty("name_symbol")
    @Column(name = "name_symbol")
    private String nameSymbol;

    @JsonProperty("named_by")
    @Column(name = "named_by")
    private String namedBy;

    @JsonProperty("naming")
    @Column(name = "naming")
    private String naming;

    @JsonProperty("number")
    @Column(name = "number")
    private Integer number;

    @JsonProperty("oxidation_states")
    @Column(name = "oxidation_states")
    private String oxidationStates;

    @JsonProperty("p_(pa)")
    @Column(name = "p_(pa)")
    private String pPa;

    @JsonProperty("per_shell")
    @Column(name = "per_shell")
    private String perShell;

    @JsonProperty("period")
    @Column(name = "period")
    private String period;

    @JsonProperty("phase")
    @Column(name = "phase")
    private String phase;

    @JsonProperty("poisson_ratio")
    @Column(name = "poisson_ratio")
    private String poissonRatio;

    @JsonProperty("prediction")
    @Column(name = "prediction")
    private String prediction;

    @JsonProperty("pronunciation")
    @Column(name = "pronunciation")
    private String pronunciation;

    @JsonProperty("proposed_formal_name")
    @Column(name = "proposed_formal_name")
    private String proposedFormalName;

    @JsonProperty("recognised_as_an_element_by")
    @Column(name = "recognised_as_an_element_by")
    private String recognisedAsAnElementBy;

    @JsonProperty("recognized_as_a_distinct_element_by")
    @Column(name = "recognized_as_a_distinct_element_by")
    private String recognizedAsADistinctElementBy;

    @JsonProperty("recognized_as_a_unique_metal_by")
    @Column(name = "recognized_as_a_unique_metal_by")
    private String recognizedAsAUniqueMetalBy;

    @JsonProperty("recognized_as_an_element_by")
    @Column(name = "recognized_as_an_element_by")
    private String recognizedAsAnElementBy;

    @JsonProperty("shear_modulus")
    @Column(name = "shear_modulus")
    private String shearModulus;

    @JsonProperty("speed_of_sound")
    @Column(name = "speed_of_sound")
    private String speedOfSound;

    @JsonProperty("speed_of_sound_thin_rod")
    @Column(name = "speed_of_sound_thin_rod")
    private String speedOfSoundThinRod;

    @JsonProperty("sublimation_point")
    @Column(name = "sublimation_point")
    private String sublimationPoint;

    @JsonProperty("symbol")
    @Column(name = "symbol")
    private String symbol;

    @JsonProperty("tensile_strength")
    @Column(name = "tensile_strength")
    private String tensileStrength;

    @JsonProperty("thermal_conductivity")
    @Column(name = "thermal_conductivity")
    private String thermalConductivity;

    @JsonProperty("thermal_diffusivity")
    @Column(name = "thermal_diffusivity")
    private String thermalDiffusivity;

    @JsonProperty("thermal_expansion")
    @Column(name = "thermal_expansion")
    private String thermalExpansion;

    @JsonProperty("triple_point")
    @Column(name = "triple_point")
    private String triplePoint;

    @JsonProperty("van_der_waals_radius")
    @Column(name = "van_der_waals_radius")
    private String vanDerWaalsRadius;

    @JsonProperty("vickers_hardness")
    @Column(name = "vickers_hardness")
    private String vickersHardness;

    @JsonProperty("when_liquid_at_bp")
    @Column(name = "when_liquid_at_bp")
    private String whenLiquidAtBp;

    @JsonProperty("when_liquid_at_mp")
    @Column(name = "when_liquid_at_mp")
    private String whenLiquidAtMp;

    @JsonProperty("youngs_modulus")
    @Column(name = "youngs_modulus")
    private String youngsModulus;

}