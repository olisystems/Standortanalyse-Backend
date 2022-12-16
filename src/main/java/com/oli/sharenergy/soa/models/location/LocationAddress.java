package com.oli.sharenergy.soa.models.location;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "tbl_location_Address")
public class LocationAddress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int locationAddressID;
    private String locationID;
    private String street;
    private String houseNumber;
    private int plz;
    private String city;
}
