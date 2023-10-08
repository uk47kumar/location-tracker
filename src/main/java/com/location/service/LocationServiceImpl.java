package com.location.service;

import com.location.entity.Location;
import com.location.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class LocationServiceImpl implements LocationService{

    private LocationRepository locationRepository;

    @Autowired
    public LocationServiceImpl(LocationRepository locationRepository){
        this.locationRepository = locationRepository;
    }

    @Transactional
    @Override
    public Location save(Location theLocation) {
        return locationRepository.save(theLocation);
    }
}
