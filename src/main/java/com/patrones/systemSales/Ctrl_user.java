package com.patrones.systemSales;

import com.patrones.systemSales.services.UserServiceImpl;
import com.patrones.systemSales.model.User;
import com.patrones.systemSales.decorator.UserServiceLoggingDecorator;
import com.patrones.systemSales.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class Ctrl_user {

    private final UserService userService;

    @Autowired
    public Ctrl_user(UserServiceImpl userServiceImpl) {
        this.userService = new UserServiceLoggingDecorator(userServiceImpl);
    }

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll();
        return ResponseEntity.ok(users);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        if (userService.login(user)) {
            return ResponseEntity.ok("Login exitoso");
        } else {
            return ResponseEntity.status(401).body("Credenciales incorrectas");
        }
    }

    @PostMapping("/register")
    public ResponseEntity<Boolean> register(@RequestBody User user) {
        return ResponseEntity.ok(userService.save(user));
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Boolean> update(@RequestBody User user, @PathVariable int id) {
        return ResponseEntity.ok(userService.update(user, id));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable int id) {
        return ResponseEntity.ok(userService.delete(id));
    }
}
