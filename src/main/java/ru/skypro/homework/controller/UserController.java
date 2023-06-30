package ru.skypro.homework.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.dto.UserUpdateDto;
import ru.skypro.homework.service.impl.UserService;

@ControllerAdvice
@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/users")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @ExceptionHandler({HttpClientErrorException.Unauthorized.class, HttpClientErrorException.Forbidden.class})
    @PostMapping("/set_password")
    public void setPassword(@RequestParam("currentPassword") String currentPassword,
                            @RequestParam("newPassword") String newPassword) {
        service.updatePassword(currentPassword, newPassword);
    }

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    @GetMapping("/me")
    public UserDto getUser() {
        return service.getUser();
    }

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    @PatchMapping("/me")
    public UserUpdateDto updateUser(@RequestBody UserUpdateDto updateDto) {
        return service.updateUser(updateDto);
    }

    @ExceptionHandler(HttpClientErrorException.Unauthorized.class)
    @PatchMapping(value = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public void updateAvatar(@RequestParam("image") MultipartFile avatar) {
        service.updateAvatar(avatar);
    }
}