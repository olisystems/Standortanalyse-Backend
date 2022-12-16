package com.oli.sharenergy.soa.repository;

import com.oli.sharenergy.soa.models.location.LocationAddress;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface LocationAddressRepo extends JpaRepository<LocationAddress, Integer> {

    Optional<LocationAddress> findLocationAddressBylocationAddressID(int locationAddressID);

   List<LocationAddress> findAll();

    Optional<LocationAddress> findBylocationID(String locationID);
}
