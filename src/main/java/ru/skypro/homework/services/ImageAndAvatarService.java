package ru.skypro.homework.services;
import org.springframework.web.multipart.MultipartFile;
import java.io.IOException;

public interface ImageAndAvatarService<T> {
    void remove(T object);

    T uploadImage(MultipartFile file) throws IOException;

    T getImageById(Integer id);
}
