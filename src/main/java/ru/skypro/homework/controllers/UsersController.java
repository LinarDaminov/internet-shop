package ru.skypro.homework.controllers;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UserDTO;
import ru.skypro.homework.services.impl.AvatarServiceImpl;
import ru.skypro.homework.services.impl.UserServiceImpl;
import java.io.IOException;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserServiceImpl userService;
    private final AvatarServiceImpl avatarService;

    //Обновление пароля
    @PostMapping("/set_password")
    public ResponseEntity<?> setPassword(@RequestBody NewPassword newPassword,
                                         Authentication authentication) {
        userService.updatePassword(newPassword, authentication);
        return ResponseEntity.ok().build();
    }

    //Обновление информации об авторизованном пользователе
    @PatchMapping("/me")
    public ResponseEntity<UserDTO> updateUser(@RequestBody UserDTO userDto,
                                              Authentication authentication) {
        return ResponseEntity.ok(userService.updateUser(userDto, authentication));
    }

    //Обновление аватара авторизованного пользователя
    @PatchMapping(value = "/me/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateUserAvatar(@RequestPart("image") MultipartFile avatarFile,
                                              Authentication authentication) throws IOException {
        userService.updateUserAvatar(avatarFile, authentication);
        return ResponseEntity.ok().build();
    }

    //Получение информации об авторизованном пользователе
    @GetMapping("/me")
    public ResponseEntity<UserDTO> getUser(Authentication authentication) {
        return ResponseEntity.ok(userService.getUser(authentication));
    }

    //Получение аватара пользователя по идентификатору
    @Operation(hidden = true)
    @GetMapping(value = "/avatar/{id}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public byte[] getAvatar(@PathVariable("id") Integer id) {
        return avatarService.getImageById(id).getData();
    }
}
