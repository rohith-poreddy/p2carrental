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

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.Customer;
import com.example.demo.service.CustomerService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/customer")
public class CustomerController {
	
	@Autowired
	private CustomerService customerService;

	@GetMapping(value = "/{customerId}")
    public ResponseEntity<Customer> getCustomer(@PathVariable String customerId){
		return new ResponseEntity<Customer>(customerService.getCustomer(customerId), HttpStatus.OK);
    }
	
	@PutMapping
    public void updateCustomer(@RequestBody CustomerDto customerDto) {
		customerService.updateCustomer(customerDto);
    }
}

