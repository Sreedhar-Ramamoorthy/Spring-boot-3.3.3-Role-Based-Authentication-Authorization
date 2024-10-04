package com.setup.basicSetup.requestDto;

import lombok.Data;

@Data
public class UserRequest {
    private String userName;
    private String age;
    private String mobileNo;
    private String role;
    private String email;
    private String password;
}
