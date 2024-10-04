package com.setup.basicSetup.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String userName;
    private String age;
    private String mobileNo;

    private String email;
    private String password;


    @ManyToOne
    @JoinColumn(name = "roles_id")
    private Role role;

}
