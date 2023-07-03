package ru.skypro.homework.services;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UserDTO;
import java.io.IOException;

public interface UserService {
    void updatePassword(NewPassword newPassword, Authentication authentication);

    UserDTO getUser(Authentication authentication);

    UserDTO updateUser(UserDTO userDTO, Authentication authentication);

    void updateUserAvatar(MultipartFile avatar, Authentication authentication) throws IOException;

}
