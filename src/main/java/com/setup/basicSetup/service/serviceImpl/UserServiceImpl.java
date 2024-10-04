package com.setup.basicSetup.service.serviceImpl;

import com.setup.basicSetup.entity.Role;
import com.setup.basicSetup.entity.User;
import com.setup.basicSetup.repositories.RoleRepository;
import com.setup.basicSetup.repositories.UserRespository;
import com.setup.basicSetup.requestDto.UserRequest;
import com.setup.basicSetup.responseDto.CommonResponse;
import com.setup.basicSetup.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    UserRespository userRespository;

    @Autowired
    PasswordEncoder passwordEncoder;

    @Override
    public CommonResponse createNewUser(UserRequest userRequest) {

        User user = new User();
        user.setUserName(userRequest.getUserName());
        user.setAge(userRequest.getAge());
        user.setMobileNo(userRequest.getMobileNo());
        user.setEmail(userRequest.getEmail());
        user.setPassword(passwordEncoder.encode(userRequest.getPassword()));
        Role role = roleRepository.findById(userRequest.getRole()).orElseThrow(() ->
                new RuntimeException("invalid id"));
        user.setRole(role);
        userRespository.save(user);

        return CommonResponse.builder().code(200).data(user.getId()).build();
    }

    @Override
    public CommonResponse getAllUsers() {
        List<User> list = userRespository.findAll();
        return CommonResponse.builder().code(200).data(list).build();

    }
}
