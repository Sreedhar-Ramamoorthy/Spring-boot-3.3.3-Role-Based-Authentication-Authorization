package com.setup.basicSetup.service;

import com.setup.basicSetup.requestDto.RoleRequest;
import com.setup.basicSetup.responseDto.CommonResponse;

public interface RoleService  {
    CommonResponse createNewRole(RoleRequest roleRequest);

    CommonResponse getAllRole();
}
