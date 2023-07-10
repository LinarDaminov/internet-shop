package ru.skypro.homework.services.impl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.exceptions.ImageNotFoundException;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.repositories.ImageRepository;
import ru.skypro.homework.services.ImageAndAvatarService;
import java.io.IOException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class ImageServiceImpl implements ImageAndAvatarService<Image> {

    private final ImageRepository imageRepository;

    @Override
    public void remove(Image image) {
        imageRepository.delete(image);
        log.info("Image removed successfully");

    }

    @Override
    public Image uploadImage(MultipartFile file) throws IOException {
        log.debug("Uploading image file: " + file.getOriginalFilename());
        Image image = new Image();
        image.setMediaType(file.getContentType());
        image.setFileSize(file.getSize());
        image.setData(file.getBytes());
        Image savedImage = imageRepository.save(image);
        log.info("Image successfully uploaded with id {}", savedImage.getId());
        return savedImage;
    }

    @Override
    public Image getImageById(Integer id) {
        log.debug("Get image with id: {}", id);
        return imageRepository.findById(id).orElseThrow(ImageNotFoundException::new);
    }
}
