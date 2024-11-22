package com.patrones.systemSales.services;

import com.patrones.systemSales.model.User;
import com.patrones.systemSales.repository.UserRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(User user) {
        return userRepository.findByUsername(user.getUsername())
                .map(foundUser -> user.getPassword().equals(foundUser.getPassword()))
                .orElse(false);
    }

    public boolean save(User user) {
        if (existsByUsername(user.getUsername())) {
            return false;
        }
        return userRepository.save(user) != null;
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public boolean update(User user, int userId) {
        try {
            user.setUserId(userId);
            return userRepository.save(user) != null;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean delete(int userId) {
        try {
            userRepository.deleteById(userId);
            return !userRepository.existsById(userId);
        } catch (Exception e) {
            return false;
        }
    }

    public List<User> findAll() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
