package ru.skypro.homework.services.impl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.NewPassword;
import ru.skypro.homework.dto.UserDTO;
import ru.skypro.homework.exceptions.BadCredentialsException;
import ru.skypro.homework.exceptions.UserNameNotFoundException;
import ru.skypro.homework.mapping.UserMapping;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repositories.UserRepository;
import ru.skypro.homework.services.UserService;
import java.io.IOException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AvatarServiceImpl avatarService;
    private final UserMapping userMapping;

    @Override
    public UserDTO getUser(Authentication authentication) {
        log.info("Return details for user: {}", authentication.getName());
        return userMapping.toDTO(getUserByUsername(authentication.getName()));
    }

    @Override
    public void updatePassword(NewPassword newPassword, Authentication authentication) {
        User user = getUserByUsername(authentication.getName());
        if (!passwordEncoder.matches(newPassword.getCurrentPassword(), user.getPassword())) {
            throw new BadCredentialsException();
        }
        user.setPassword(passwordEncoder.encode(newPassword.getNewPassword()));
        userRepository.save(user);
        log.debug("Password updated for user: {}", authentication.getName());
    }

    @Override
    public void updateUserAvatar(MultipartFile avatar, Authentication authentication) throws IOException {
        User user = getUserByUsername(authentication.getName());
        if (user.getAvatar() != null) {
            avatarService.remove(user.getAvatar());
        }
        user.setAvatar(avatarService.uploadImage(avatar));
        userRepository.save(user);
        log.debug("Avatar updated for user: {}", authentication.getName());
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Authentication authentication) {

        if(userDTO.getFirstName() == null || userDTO.getFirstName().isBlank()
                || userDTO.getLastName() == null || userDTO.getLastName().isBlank()
                || userDTO.getPhone() == null || userDTO.getPhone().isBlank()) throw new IllegalArgumentException();

        User user = getUserByUsername(authentication.getName());
        user.setFirstName(userDTO.getFirstName());
        user.setLastName(userDTO.getLastName());
        user.setPhone(userDTO.getPhone());
        userRepository.save(user);
        log.debug("User details updated for user: {}", authentication.getName());
        return userMapping.toDTO(user);
    }


    public User getUserByUsername(String username) {
        return userRepository.findByUsernameIgnoreCase(username)
                .orElseThrow(UserNameNotFoundException::new);
    }

}
