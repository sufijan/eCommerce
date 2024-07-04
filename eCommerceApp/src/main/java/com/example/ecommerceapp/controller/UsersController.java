package com.example.ecommerceapp.controller;

import com.example.ecommerceapp.model.Users;
import com.example.ecommerceapp.service.UsersService;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/user/{userId}")
public class UsersController {
    private final UsersService usersService;

    public UsersController(UsersService usersService) {
        this.usersService = usersService;
    }

    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public Optional<Users> getUser(@PathVariable(value = "userId") Long userId) {
        Optional<Users> user = usersService.getUser(userId);
        if (user.isEmpty()) {
            throw new ResponseStatusException(NOT_FOUND, "User not found.");
        }
        return user;
    }
}
