package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.SearchCarDto;
import com.example.demo.model.Car;
import com.example.demo.repo.CarRepository;

@Service
public class SearchCarService {

    @Autowired
    private CarRepository carRepository;

    public List<Car> getSearchedCars(SearchCarDto searchCarDto) {
        return carRepository.findByBrandAndLocationId(searchCarDto.getCarBrand(), searchCarDto.getLocationId());
    }
}
