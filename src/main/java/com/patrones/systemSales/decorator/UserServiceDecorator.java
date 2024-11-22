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
import java.util.List;

public abstract class UserServiceDecorator implements UserService {

    protected final UserService decoratedUserService;

    public UserServiceDecorator(UserService userService) {
        this.decoratedUserService = userService;
    }

    @Override
    public boolean login(User user) {
        return decoratedUserService.login(user);
    }

    @Override
    public boolean save(User user) {
        return decoratedUserService.save(user);
    }

    @Override
    public boolean existsByUsername(String username) {
        return decoratedUserService.existsByUsername(username);
    }

    @Override
    public boolean update(User user, int userId) {
        return decoratedUserService.update(user, userId);
    }

    @Override
    public boolean delete(int userId) {
        return decoratedUserService.delete(userId);
    }

    @Override
    public List<User> findAll() {
        return decoratedUserService.findAll();
    }
}
