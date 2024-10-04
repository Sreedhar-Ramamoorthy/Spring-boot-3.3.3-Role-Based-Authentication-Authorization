package com.setup.basicSetup.service;

import com.setup.basicSetup.requestDto.UserRequest;
import com.setup.basicSetup.responseDto.CommonResponse;

public interface UserService {
    CommonResponse createNewUser(UserRequest userRequest);

    CommonResponse getAllUsers();
}
