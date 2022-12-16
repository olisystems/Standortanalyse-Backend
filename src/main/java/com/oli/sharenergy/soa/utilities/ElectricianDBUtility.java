package com.oli.sharenergy.soa.utilities;

import com.oli.sharenergy.soa.models.exceptions.ElectricianCollectionException;
import com.oli.sharenergy.soa.models.exceptions.ElectricianUtilityException;
import com.oli.sharenergy.soa.models.exceptions.LocationUitilityException;
import com.oli.sharenergy.soa.models.location.Electrician;
import com.oli.sharenergy.soa.repository.ElectricianRepo;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
@AllArgsConstructor
public class ElectricianDBUtility {

    private final ElectricianRepo electricianRepo;

    public void saveElectrician(Electrician electrician) {
        try {
            log.info("Successfully saved Electrician in DB.");
            electricianRepo.save(electrician);
        } catch (Exception e) {
            log.error("Something happened during saving the Electrician data: " + electrician);
            log.error("Exception: " + e);
            throw new ElectricianCollectionException();
        }
    }

    public Optional<Electrician> findElectricianByElectricianID(int ElectricianID){
        Optional<Electrician> electrician = electricianRepo.findById(ElectricianID);
        if (electrician.isEmpty()) {
            log.info("Can't find Electrician with ElectricianID: " + ElectricianID);
            throw new ElectricianUtilityException("Exception occurred while getting the Electrician from the ElectricianID");
        }
        return electrician;
    }

    public Iterable<Electrician> findAll(){
        try {
            return electricianRepo.findAll();
        } catch (Exception e){
            log.error("Unknown Error occured, please Inform the OLI-Team");
            throw new LocationUitilityException("Unknown Exception occured while finding all existing Electrician ");
        }
    }

    public Optional<Electrician> findElectricianByLocationID(String locationID){
        Optional<Electrician> electrician = electricianRepo.findBylocationID(locationID);
        if (electrician.isEmpty()) {
            log.info("Can't find Electrician connected with that LocationID: " + locationID);
            throw new ElectricianUtilityException("Exception occurred while getting the Electrician from the LocationID");
        }
        return electrician;
    }
}
