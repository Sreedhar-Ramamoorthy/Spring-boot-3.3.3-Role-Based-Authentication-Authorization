package com.setup.basicSetup.controller;

import com.setup.basicSetup.requestDto.RoleRequest;
import com.setup.basicSetup.responseDto.CommonResponse;
import com.setup.basicSetup.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/roles")
public class RoleController {
    @Autowired
    RoleService roleService;

    @PostMapping("/create/role")
    public CommonResponse createRole(@RequestBody RoleRequest roleRequest){
        return roleService.createNewRole(roleRequest);
    }
    @GetMapping("/get/role")
    public CommonResponse getRole(){
        return roleService.getAllRole();
    }
}
