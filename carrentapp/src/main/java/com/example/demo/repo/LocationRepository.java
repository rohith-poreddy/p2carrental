package com.example.demo.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Location;

@Repository
public interface LocationRepository extends JpaRepository<Location, Long> {
    List<Location> findAllByDealerId(String dealerId);
}