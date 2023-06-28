package ru.skypro.homework.service.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.repositories.AdsRepository;
import ru.skypro.homework.utils.MappingUtils;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

@Service
public class AdsService {
    private final AdsRepository adsRepository;
    private final MappingUtils mappingUtils;

    public AdsService(AdsRepository adsRepository, MappingUtils mappingUtils) {
        this.adsRepository = adsRepository;
        this.mappingUtils = mappingUtils;
    }

    public List<Ad> getAllAds() {
        return adsRepository.findAll();
    }

    public AdDto createAd(CreateOrUpdateAdDto createDto, MultipartFile image) {
        try {
            Path imageReference = Files.createFile(Path.of("/resources/images" + image.getOriginalFilename()));
            adsRepository.saveAndFlush(mappingUtils.mapToAd(createDto, String.valueOf(imageReference)));
            return mappingUtils.mapToAdDto(adsRepository.getByUserId(AuthServiceImpl.getAuthUser().getId()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public ExtendedAdDto getAdInfo(Integer adId) {
        return mappingUtils.mapToExtendedAdDto(adsRepository.getByAdId(adId));
    }
}