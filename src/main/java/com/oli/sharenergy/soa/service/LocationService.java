package com.oli.sharenergy.soa.service;

import com.oli.sharenergy.soa.models.exceptions.LocationCollectionException;
import com.oli.sharenergy.soa.models.exceptions.LocationServiceException;
import com.oli.sharenergy.soa.models.location.Location;
import com.oli.sharenergy.soa.utilities.CustomerDBUtility;
import com.oli.sharenergy.soa.utilities.ElectricianDBUtility;
import com.oli.sharenergy.soa.utilities.LocationAddressDBUtility;
import com.oli.sharenergy.soa.utilities.LocationDBUtility;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@AllArgsConstructor
public class LocationService {

    private static final String UNKNOWN_ERROR_MSG = "Unknown error occurred, please contact our support!";

    private final LocationDBUtility locationDBUtility;
    private final CustomerDBUtility customerDBUtility;
    private final ElectricianDBUtility electricianDBUtility;
    private final LocationAddressDBUtility locationAddressDBUtility;

    public String createLocation(Location location){
        log.info("Going to create the location for the operator: " + location.toString());
        locationDBUtility.saveLocation(location);
        return location.getLocationID();
    }

    public Location findLocationById(String locationId) {
        try {
            Location location = locationDBUtility.getLocationBylocationID(locationId);
            return location;
        } catch (LocationCollectionException e) {
            log.error("Unable to get the location information for the location Id");
            log.error("Location Id: " + locationId);
            throw new LocationServiceException("could not get the location information for the location Id, please contact our support!");
        } catch (Exception e){
            log.error("Exception occurred: " + e);
            log.error("locationId: " + locationId);
            throw new LocationServiceException(UNKNOWN_ERROR_MSG);
        }
    }

    public Location findCompleteLocationByID(String locationID){
        Location location = locationDBUtility.getLocationBylocationID(locationID);





        return location;
    }
}
