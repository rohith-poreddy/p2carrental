package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Location;
import com.example.demo.repo.LocationRepository;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;


    public List<Location> getAllLocations() {
        return (List<Location>) locationRepository.findAll();
    }

    public List<Location> getLocationsByDealerId(String dealerId) {
        return locationRepository.findAllByDealerId(dealerId);
    }
}