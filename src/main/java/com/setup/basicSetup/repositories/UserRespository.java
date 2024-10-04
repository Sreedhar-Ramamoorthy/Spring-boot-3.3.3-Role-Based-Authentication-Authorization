package com.setup.basicSetup.repositories;

import com.setup.basicSetup.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRespository extends JpaRepository<User,String> {
    User findByUserName(String username);
}
