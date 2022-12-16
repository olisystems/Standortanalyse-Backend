package com.oli.sharenergy.soa.models.location;

import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@ToString
@Entity
@Table( name = "tbl_location")
public class Location {

    @Id
    private String locationID;
    private String locationName;
    private LocationAddress locationAddress;
    private Customer customer;
    private String internal_External;
    private Electrician electrician;
    private String projectNumber;
}
