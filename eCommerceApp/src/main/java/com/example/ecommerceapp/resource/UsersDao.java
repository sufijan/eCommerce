package com.example.ecommerceapp.resource;

import com.example.ecommerceapp.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersDao extends JpaRepository<Users, Long> {

    @Override
    Optional<Users> findById(Long aLong);
}
