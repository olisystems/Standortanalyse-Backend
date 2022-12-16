package com.oli.sharenergy.soa.models.ode;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "tbl_ode")
public class ODE {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String odeID;
    private String objectName;
    //private GeneralData generalData;
    //private SpecificObjectData specificObjectData;
    private String notes;
}
