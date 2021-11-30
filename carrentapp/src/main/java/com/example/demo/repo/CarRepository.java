package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Car;

@Repository
public interface CarRepository extends JpaRepository<Car, String> {
	
    Car findByRegistrationNo(String registrationNo);

    List<Car> findByBrandAndLocationId(String carBrand, Long locationId);

	List<Car> findByDealerId(String dealerId);

	void deleteByRegistrationNo(String registrationNo);
}
