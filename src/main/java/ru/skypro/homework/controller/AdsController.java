package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.service.impl.AdsService;

import java.util.List;

@RestController
@CrossOrigin(value = "http://localhost:3000")
public class AdsController {
    private final AdsService adsService;

    public AdsController(AdsService adsService) {
        this.adsService = adsService;
    }

    @GetMapping("/ads")
    public List<Ad> getAll() {
        return adsService.getAllAds();
    }

    @PostMapping("/ads")
    public AdDto addAd(CreateOrUpdateAdDto properties, MultipartFile image) {
        return adsService.createAd(properties, image);
    }

    @GetMapping("/ads/{id}")
    public ExtendedAdDto getAd(@RequestParam Integer adId) {
        return adsService.getAdInfo(adId);
    }

    @DeleteMapping("/ads/{id}")
    public void deleteAd(@RequestParam Integer id) {

    }

    @PatchMapping("/ads/{id}")
    public void updateAd(@RequestParam Integer id) {

    }

    @GetMapping("/ads/me")
    public ResponseEntity<?> getUserAds() {
        return null;
    }

    @PatchMapping("/ads/{id}/image")
    public void updateAdImage(@RequestParam Integer id) {

    }
}
