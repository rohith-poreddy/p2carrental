package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.DealerDto;

import com.example.demo.model.Dealer;
import com.example.demo.service.DealerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/dealer")
public class DealerController {

    @Autowired
    private DealerService dealerService;

//    @GetMapping(value = "/{dealerId}")
//    public ResponseEntity<Dealer> getDealer(@PathVariable String dealerId){
//        return new ResponseEntity<Dealer>(dealerService.getDealer(dealerId), HttpStatus.OK);
//    }
    @GetMapping(value = "/{dealerId}")
    public Dealer getDealer(@PathVariable String dealerId){
        return dealerService.getDealer(dealerId);
    }
    
    
    @PutMapping
    public void updateDealer(@RequestBody DealerDto dealerDto) {
    	dealerService.updateDealer(dealerDto);
    }
    
}
