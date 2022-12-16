package com.oli.sharenergy.soa.repository;

import com.oli.sharenergy.soa.models.location.Location;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocationRepo extends JpaRepository<Location, String> {

    Optional<Location> findLocationBylocationID(String locationID);

    List<Location> findAll();
}
