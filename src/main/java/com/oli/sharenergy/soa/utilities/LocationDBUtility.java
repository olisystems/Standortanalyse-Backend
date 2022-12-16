package com.oli.sharenergy.soa.utilities;

import com.oli.sharenergy.soa.models.exceptions.LocationCollectionException;
import com.oli.sharenergy.soa.models.exceptions.LocationUitilityException;
import com.oli.sharenergy.soa.models.location.Location;
import com.oli.sharenergy.soa.repository.LocationRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
@Slf4j
public class LocationDBUtility {

    @Autowired
    private LocationRepo locationRepo;

    public void saveLocation(Location location) {
        try {
            log.info("Successfully saved location in DB.");
            locationRepo.save(location);
        } catch (Exception e) {
            log.error("Something happened during saving the location data: " + location);
            log.error("Exception: " + e);
            throw new LocationCollectionException();
        }
    }

    public Location getLocationBylocationID(String locationId) {
        try {
            Optional<Location> locationOptional = locationRepo.findLocationBylocationID(locationId);
            if (locationOptional.isEmpty()) {
                throw new LocationCollectionException();
            }
            return locationOptional.get();
        } catch (Exception e) {
            throw new LocationCollectionException();
        }
    }

    public Optional<Location> findLocationBylocationID(String locationID){
        Optional<Location> location = locationRepo.findById(locationID);
        if (location.isEmpty()) {
            log.info("Can't find Location with LocationID: " + locationID);
            throw new LocationUitilityException("Exception occurred while getting the Location from the LocationID");
        }
        return location;
    }

    public Iterable<Location> findAll(){
        try {
            return locationRepo.findAll();
        } catch (Exception e){
            log.error("Unknown Error occured, please Inform the OLI-Team");
            throw new LocationUitilityException("Unknown Exception occured while finding all existing Locations ");
        }

    }
}
