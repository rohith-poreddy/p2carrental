package com.example.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.CarDto;

import com.example.demo.model.Car;
import com.example.demo.service.CarService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/car")
public class CarController {

	@Autowired
	private CarService carService;
	
	@PostMapping
	public ResponseEntity<Car> addCar(@Valid @RequestBody CarDto carDto) {
		return new ResponseEntity<Car>(carService.addCar(carDto), HttpStatus.OK);
	}

	@GetMapping(value = "/registration/{registrationNo}")
	public ResponseEntity<Car> getCar(@PathVariable String registrationNo) {
		return new ResponseEntity<Car>(carService.getCar(registrationNo), HttpStatus.OK);
	}

	@GetMapping(value = "/dealer/{dealerId}")
	public ResponseEntity<List<Car>>  getAllCarByDealerId(@PathVariable String dealerId) {
		return new ResponseEntity<List<Car>>(carService.getAllCarByDealerId(dealerId), HttpStatus.OK);
	}

	@GetMapping
	public ResponseEntity<List<Car>>  getAllCar() {
		return new ResponseEntity<List<Car>>(carService.getAllCar(), HttpStatus.OK);
	}

	@PutMapping
	public void updateCar(@RequestBody CarDto carDto) {
		carService.updateCar(carDto);
	}

	@DeleteMapping(value = "/{registrationNo}")
	public void updateCar(@PathVariable String registrationNo) {
		carService.deleteCar(registrationNo);
	}
}
