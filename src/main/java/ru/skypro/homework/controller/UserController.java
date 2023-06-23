package ru.skypro.homework.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/users")
public class UserController {
    @PostMapping("/set_password")
    public ResponseEntity<?> setPassword(@RequestParam("currentPassword") String currentPassword,
                                      @RequestParam("newPassword") String newPassword) {
        //TODO Проверить наличие авторизованного пользователя по текущему паролю
        return new ResponseEntity<>(newPassword, HttpStatus.ACCEPTED);
    }

    @GetMapping("/me")
    public void getUser() {
    }

    @PatchMapping("/me")
    public void updateUser() {
    }

    @PatchMapping("/me/image")
    public void updateAvatar() {
    }
}
