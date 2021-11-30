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

import com.example.demo.dto.BookingDto;
import com.example.demo.model.Booking;
import com.example.demo.service.BookingService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/booking")
public class BookingController {

    @Autowired
    private BookingService bookingService;

    @PostMapping
    public void doBooking(@RequestBody BookingDto bookingDto){
        bookingService.confirmBooking(bookingDto);
    }
    
    @GetMapping(value="/customer/{custId}")
    public ResponseEntity<List<Booking>> getCustomerBooking(@PathVariable String custId) {
    	 return new ResponseEntity<List<Booking>>(bookingService.getCustomerBooking(custId), HttpStatus.OK);
    }

    @GetMapping(value="/dealer/{dealerId}")
    public ResponseEntity<List<Booking>> getDealerBooking(@PathVariable String dealerId) {
    	 return new ResponseEntity<List<Booking>>(bookingService.getDealerBooking(dealerId), HttpStatus.OK);

    }
}

