package com.example.springbootmysql.repositories;

import com.example.springbootmysql.models.UserDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepo extends JpaRepository<UserDTO, Integer> {

    UserDTO findByEmail(String email);
}
