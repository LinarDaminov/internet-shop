package ru.skypro.homework.services.impl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdsDTO;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.dto.FullAds;
import ru.skypro.homework.services.AdsService;

import java.io.IOException;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AdsServiceImpl implements AdsService {
    @Override
    public List<AdsDTO> getAllAds() {
        return null;
    }

    @Override
    public AdsDTO addAds(MultipartFile imageFiles, CreateAds createAds, Authentication authentication) throws IOException {
        return null;
    }

    @Override
    public FullAds getAdsById(Integer id) {
        return null;
    }

    @Override
    public void removeAdsById(Integer id) {

    }

    @Override
    public AdsDTO updateAds(Integer id, CreateAds createAds) {
        return null;
    }

    @Override
    public void updateAdsImage(Integer id, MultipartFile imageFile) throws IOException {

    }

    @Override
    public List<AdsDTO> getAdsMe(Authentication authentication) {
        return null;
    }
}
