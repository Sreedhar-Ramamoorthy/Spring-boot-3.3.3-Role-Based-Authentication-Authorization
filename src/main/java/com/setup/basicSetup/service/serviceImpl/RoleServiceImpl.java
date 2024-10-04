package com.setup.basicSetup.service.serviceImpl;

import com.setup.basicSetup.entity.Role;
import com.setup.basicSetup.repositories.RoleRepository;
import com.setup.basicSetup.requestDto.RoleRequest;
import com.setup.basicSetup.responseDto.CommonResponse;
import com.setup.basicSetup.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    RoleRepository roleRepository;

    @Override
    public CommonResponse createNewRole(RoleRequest roleRequest) {

        Role role = new Role();
        role.setRole(roleRequest.getRole());
        roleRepository.save(role);
        return CommonResponse.builder().code(200).data(role.getId()).build();

    }

    @Override
    public CommonResponse getAllRole() {
        List<Role> roles = roleRepository.findAll();
        return CommonResponse.builder().code(200).data(roles).build();
    }
}
