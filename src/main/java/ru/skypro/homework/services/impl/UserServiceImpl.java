package ru.skypro.homework.services.impl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UserDTO;
import ru.skypro.homework.services.UserService;
import java.io.IOException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    @Override
    public void updatePassword(NewPassword newPassword, Authentication authentication) {

    }

    @Override
    public UserDTO getUser(Authentication authentication) {
        return null;
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Authentication authentication) {
        return null;
    }

    @Override
    public void updateUserAvatar(MultipartFile avatar, Authentication authentication) throws IOException {

    }
}
