package com.setup.basicSetup.controller;


import com.setup.basicSetup.configs.Jwt.JwtService;
import com.setup.basicSetup.requestDto.LoginRequest;
import com.setup.basicSetup.responseDto.CommonResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    @Autowired
    AuthenticationManager authenticationManager;
    @Autowired
    JwtService jwtService;

    @PostMapping("/login")
    public CommonResponse login(@RequestBody LoginRequest loginRequest) {
        Authentication authentication = authenticationManager
                .authenticate(new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword()));
        if (authentication.isAuthenticated()) {
            return CommonResponse.builder().code(200).data(jwtService.generateToken(authentication)).build();

        } else {
            return CommonResponse.builder().code(404).data("failed  ").build();

        }
    }
}
