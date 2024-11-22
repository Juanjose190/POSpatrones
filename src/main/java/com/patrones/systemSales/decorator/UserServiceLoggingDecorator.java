/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.patrones.systemSales.decorator;

/**
 *
 * @author JUAN JOSE
 */


import com.patrones.systemSales.model.User;
import com.patrones.systemSales.services.UserService;
import java.util.logging.Logger;
import java.util.List;

public class UserServiceLoggingDecorator extends UserServiceDecorator {

    private static final Logger LOGGER = Logger.getLogger(UserServiceLoggingDecorator.class.getName());

    public UserServiceLoggingDecorator(UserService userService) {
        super(userService);
    }

    @Override
    public boolean login(User user) {
        LOGGER.info("Logging in user: " + user.getUsername());
        return super.login(user);
    }

    @Override
    public boolean save(User user) {
        LOGGER.info("Saving user: " + user.getUsername());
        return super.save(user);
    }

    @Override
    public boolean update(User user, int userId) {
        LOGGER.info("Updating user with ID: " + userId);
        return super.update(user, userId);
    }

    @Override
    public boolean delete(int userId) {
        LOGGER.info("Deleting user with ID: " + userId);
        return super.delete(userId);
    }
}
