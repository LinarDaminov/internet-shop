package ru.skypro.homework.services.impl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.exceptions.ImageNotFoundException;
import ru.skypro.homework.model.Avatar;
import ru.skypro.homework.repositories.AvatarRepository;
import ru.skypro.homework.services.ImageAndAvatarService;
import java.io.IOException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AvatarServiceImpl implements ImageAndAvatarService<Avatar> {

    private final AvatarRepository avatarRepository;
    @Override
    public void remove(Avatar avatar) {
        log.debug("Removing avatar with id {}", avatar.getId());
        avatarRepository.delete(avatar);
        log.info("Avatar removed successfully");

    }

    @Override
    public Avatar uploadImage(MultipartFile file) throws IOException {
        log.debug("Uploading avatar file: {}", file.getOriginalFilename());
        Avatar avatar = new Avatar();
        avatar.setMediaType(file.getContentType());
        avatar.setFileSize(file.getSize());
        avatar.setData(file.getBytes());
        Avatar savedAvatar = avatarRepository.save(avatar);
        log.info("Avatar successfully uploaded with id {}", savedAvatar.getId());
        return savedAvatar;
    }

    @Override
    public Avatar getImageById(Integer id) {
        log.debug("Getting avatar with id: {}", id);
        return avatarRepository.findById(id).orElseThrow(ImageNotFoundException::new);
    }
}
