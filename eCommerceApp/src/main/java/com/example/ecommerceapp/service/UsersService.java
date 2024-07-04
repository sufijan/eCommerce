package com.example.ecommerceapp.service;

import com.example.ecommerceapp.model.Users;
import com.example.ecommerceapp.resource.UsersDao;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsersService {
    private final UsersDao userDao;

    public UsersService(UsersDao userDao) {
        this.userDao = userDao;
    }

    public List<Users> getUsers() {
        return userDao.findAll();
    }

    public Optional<Users> getUser(Long id) {
        return userDao.findById(id);
    }

    public Users addUser(Users user) {
        return userDao.save(user);
    }

    public void deleteProduct(Long id) {
        userDao.deleteById(id);
    }
}
