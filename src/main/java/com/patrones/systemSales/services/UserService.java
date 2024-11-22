package com.patrones.systemSales.services;

import com.patrones.systemSales.model.User;
import java.util.List;

public interface UserService {
    boolean login(User user);
    boolean save(User user);
    boolean existsByUsername(String username);
    boolean update(User user, int userId);
    boolean delete(int userId);
    List<User> findAll();
}
