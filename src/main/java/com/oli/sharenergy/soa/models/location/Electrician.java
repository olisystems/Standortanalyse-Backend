package com.oli.sharenergy.soa.models.location;

import lombok.Data;
import lombok.ToString;

import javax.persistence.*;

@Data
@ToString
@Entity
@Table(name = "tbl_electrician")
public class Electrician {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int electricianID;
    private String locationID;
    private String forename;
    private String lastName;
    private String email;
    private String phoneNumber;
}
