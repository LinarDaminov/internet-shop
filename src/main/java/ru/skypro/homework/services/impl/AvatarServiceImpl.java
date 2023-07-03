package ru.skypro.homework.services.impl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.services.ImageAndAvatarService;
import java.io.IOException;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AvatarServiceImpl implements ImageAndAvatarService {
    @Override
    public void remove(Object object) {

    }

    @Override
    public Object uploadImage(MultipartFile file) throws IOException {
        return null;
    }

    @Override
    public Object getImageById(Integer id) {
        return null;
    }
}
