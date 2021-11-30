package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.LoginResponse;
import com.example.demo.service.LoginService;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/login")
public class LoginController {
	
	@Autowired
    private LoginService loginService;

    @PostMapping
    public ResponseEntity<LoginResponse> registerUser(@RequestBody LoginDto dto) {
    	
        return new ResponseEntity<LoginResponse>(loginService.checkLogin(dto), HttpStatus.OK);
    }

}
