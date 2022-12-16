package com.oli.sharenergy.soa.models.ode;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "tbl_ode_GeneralData")
public class GeneralData {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int generalDataID;
    private int constructionYear;
    private String typeOfUse;
    private String typeOfHotWaterGeneration;
    private String typeOfRoofSurface;
    private String cyclicProducer;
    private boolean transformerAvailable;
    private String transformerID;
    private boolean documentsElectricalInfrastructureAvailable;
    private boolean documentsConnectedLoadAvailable;
    private boolean loadProfilesMeasured;
}
