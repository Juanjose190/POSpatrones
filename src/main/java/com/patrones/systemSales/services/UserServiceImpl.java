/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patrones.systemSales.services;

/**
 *
 * @author JUAN JOSE
 */


import com.patrones.systemSales.model.User;
import com.patrones.systemSales.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public boolean login(User user) {
        return userRepository.findByUsername(user.getUsername())
                .map(foundUser -> user.getPassword().equals(foundUser.getPassword()))
                .orElse(false);
    }

    @Override
    public boolean save(User user) {
        if (existsByUsername(user.getUsername())) {
            return false;
        }
        return userRepository.save(user) != null;
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public boolean update(User user, int userId) {
        try {
            user.setUserId(userId);
            return userRepository.save(user) != null;
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public boolean delete(int userId) {
        try {
            userRepository.deleteById(userId);
            return !userRepository.existsById(userId);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
