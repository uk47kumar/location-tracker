package com.location.rest;

import com.location.entity.Location;
import com.location.service.LocationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
@RequestMapping("/locations")
public class LocationController {

    private LocationService locationService;

    @Autowired
    public LocationController(LocationService locationService){
        this.locationService = locationService;
    }


//    http://localhost:8080/ClickMe.html

    @PostMapping
    public ResponseEntity<?> saveLocation(@RequestBody Location locationRequest) {
        try {
            // Create a new Location object from the request data
            Location location = new Location(locationRequest.getLatitude(), locationRequest.getLongitude(), new Date());

            // Save the location to the database using the repository
            Location savedLocation = locationService.save(location);

            return ResponseEntity.ok(savedLocation);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body("Failed to save location data: " + e.getMessage());
        }
    }

}
