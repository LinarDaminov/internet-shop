package ru.skypro.homework.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@CrossOrigin(value = "http://localhost:3000")
public class AdsController {
    @GetMapping("/ads")
    public ResponseEntity<?> getAll() {
        return null;
    }

    @PostMapping("/ads")
    public void addAd(Object properties, MultipartFile image) {

    }

    @GetMapping("/ads/{id}")
    public ResponseEntity<?> getAd(@RequestParam Integer id) {
        return null;
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
