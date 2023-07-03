package ru.skypro.homework.services;
import org.springframework.security.core.Authentication;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdsDTO;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.dto.FullAds;
import java.io.IOException;
import java.util.List;

public interface AdsService {
    List<AdsDTO> getAllAds();

    AdsDTO addAds(MultipartFile imageFiles, CreateAds createAds, Authentication authentication) throws IOException;

    FullAds getAdsById(Integer id);

    void removeAdsById(Integer id);

    AdsDTO updateAds(Integer id, CreateAds createAds);

    void updateAdsImage(Integer id, MultipartFile imageFile) throws IOException;

    List<AdsDTO> getAdsMe(Authentication authentication);

}
