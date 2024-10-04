package com.setup.basicSetup.controller;

import com.setup.basicSetup.requestDto.UserRequest;
import com.setup.basicSetup.responseDto.CommonResponse;
import com.setup.basicSetup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/create/user")
    public CommonResponse createUser(@RequestBody UserRequest userRequest) {
        return userService.createNewUser(userRequest);
    }

    @GetMapping("/user/get")
    public CommonResponse getAllUser() {
        return userService.getAllUsers();
    }

}
