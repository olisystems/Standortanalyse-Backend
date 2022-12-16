package com.oli.sharenergy.soa.models.ode;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "tbl_ode_SpecificObjectData")
public class SpecificObjectData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int specificObjectDataID;
    private int numberOfResidentialUnits;
    private double netFloorAreaApartments;
    private int numberOfCommercialUnits;
    private double netFloorAreaCommercial;
    private int numberOfCarParkingSpaces;
    private String typeOfParkingSpaces;
    private int desiredExpansionLevel;
}
