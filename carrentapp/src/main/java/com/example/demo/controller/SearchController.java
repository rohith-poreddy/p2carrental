package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.SearchCarDto;
import com.example.demo.model.Car;
import com.example.demo.service.SearchCarService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/search")
public class SearchController {

    @Autowired
    private SearchCarService searchCarService;

    @PostMapping
    public ResponseEntity<List<Car>> getSearchCar(@RequestBody SearchCarDto searchCarDto){
    	return new ResponseEntity<List<Car>>(searchCarService.getSearchedCars(searchCarDto), HttpStatus.OK);
    }
}
