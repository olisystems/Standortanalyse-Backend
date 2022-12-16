package com.oli.sharenergy.soa.utilities;

import com.oli.sharenergy.soa.models.exceptions.ElectricianUtilityException;
import com.oli.sharenergy.soa.models.exceptions.LocationUitilityException;
import com.oli.sharenergy.soa.models.location.LocationAddress;
import com.oli.sharenergy.soa.repository.LocationAddressRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@Component
@AllArgsConstructor
public class LocationAddressDBUtility {

    private final LocationAddressRepo locationAddressRepo;

    public Optional<LocationAddress> findLocationAddressBylocationAddressID(int locationAddressID){
        Optional<LocationAddress> locationAddress = locationAddressRepo.findById(locationAddressID);
        if (locationAddress.isEmpty()){
            log.info("Can't find LocationAddress with LocationAddressID: " + locationAddressID);
            throw new LocationUitilityException("Exception occurred while getting the LocationAddress from the LocationAddressID");
        }
        return locationAddress;
    }

    public Iterable<LocationAddress> findAll(){
        try {
            return locationAddressRepo.findAll();
        } catch (Exception e){
            log.error("Unknown Error occured, please Inform the OLI-Team");
            throw new LocationUitilityException("Unknown Exception occured while finding all existing LocationAddress ");
        }
    }

    public Optional<LocationAddress> findLocationAddressByLocationID(String locationID){
        Optional<LocationAddress> locationAddress = locationAddressRepo.findBylocationID(locationID);
        if (locationAddress.isEmpty()) {
            log.info("Can't find Address connected with that LocationID: " + locationID);
            throw new ElectricianUtilityException("Exception occurred while getting the Address from the LocationID");
        }
        return locationAddress;
    }
}
