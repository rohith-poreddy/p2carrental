package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.LoginResponse;
import com.example.demo.model.Location;
import com.example.demo.service.LocationService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/location")
public class LocationController {

    @Autowired
    private LocationService locationService;

    @GetMapping
    public  ResponseEntity<List<Location>> getLocation(){
    	return new ResponseEntity<List<Location>>(locationService.getAllLocations(), HttpStatus.OK);
    }

    @GetMapping(value = "/{dealerId}")
    public ResponseEntity<List<Location>> getLocation(@PathVariable String dealerId){
    	return new ResponseEntity<List<Location>>(locationService.getLocationsByDealerId(dealerId), HttpStatus.OK);
    }
    
    
}


