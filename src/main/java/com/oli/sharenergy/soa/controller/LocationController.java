package com.oli.sharenergy.soa.controller;

import com.oli.sharenergy.soa.models.general.GeneralizedResponseBody;
import com.oli.sharenergy.soa.models.location.Location;
import com.oli.sharenergy.soa.service.CustomerService;
import com.oli.sharenergy.soa.service.LocationService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin()
@RestController
@AllArgsConstructor
@Slf4j
@RequestMapping("/api")
public class LocationController {

    private final LocationService locationService;
    private final CustomerService customerService;

    @PostMapping("/createLocation")
    public @ResponseBody ResponseEntity<GeneralizedResponseBody<String>> createLocation(@RequestBody Location location) {
        log.info("Trying to create the location : " + location.toString());
        String locationId = locationService.createLocation(location);
        log.info("Response: " + locationId);
        GeneralizedResponseBody<String> generalizedResponseBody = new GeneralizedResponseBody<>();
        generalizedResponseBody.setData(locationId);
        return ResponseEntity.status(HttpStatus.OK).body(generalizedResponseBody);
    }

    @GetMapping("/findLocation/{locationId}")
    public @ResponseBody ResponseEntity<GeneralizedResponseBody<Location>> findLocationById(@PathVariable String locationId) {
        log.info("Trying to get Location");
        Location location = locationService.findLocationById(locationId);
        log.info("Response: {}" , location);
        GeneralizedResponseBody<Location> generalizedResponseBody = new GeneralizedResponseBody<>();
        generalizedResponseBody.setData(location);
        return ResponseEntity.status(HttpStatus.OK).body(generalizedResponseBody);
    }
}
