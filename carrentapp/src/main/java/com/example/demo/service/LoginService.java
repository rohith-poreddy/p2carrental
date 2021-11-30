package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.LoginDto;
import com.example.demo.dto.LoginResponse;
import com.example.demo.exception.InvalidRequestException;
import com.example.demo.exception.UserNotFoundException;
import com.example.demo.model.Register;
import com.example.demo.repo.RegisterRepository;

@Service
public class LoginService {

    @Autowired
    private RegisterRepository registerRepository;

    public LoginResponse checkLogin(LoginDto dto) {
        Register register = registerRepository.findByUsername(dto.getUsername());
        return new LoginResponse(register.getUsername(), register.getUserType());
        
    }
}
