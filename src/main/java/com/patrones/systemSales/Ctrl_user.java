package com.patrones.systemSales;

import com.patrones.systemSales.model.User;
import com.patrones.systemSales.services.UserService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class Ctrl_user {
    private final UserService userService;

    public Ctrl_user(UserService userService) {
        this.userService = userService;
    }

    // Agregar este nuevo endpoint
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.findAll(); // Necesitarás agregar este método en tu UserService
        return ResponseEntity.ok(users);
    }

    // ... resto de tus endpoints actuales ...

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