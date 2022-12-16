package com.oli.sharenergy.soa.repository;

import com.oli.sharenergy.soa.models.location.Electrician;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ElectricianRepo extends JpaRepository<Electrician, Integer> {

    Optional<Electrician> findElectricianByElectricianID(int ElectricianID);

    List<Electrician> findAll();

    Optional<Electrician> findBylocationID(String locationID);
}
