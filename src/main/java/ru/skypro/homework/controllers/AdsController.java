package ru.skypro.homework.controllers;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import ru.skypro.homework.dto.AdsDTO;
import ru.skypro.homework.dto.CreateAds;
import ru.skypro.homework.dto.FullAds;
import ru.skypro.homework.dto.ResponseWrapper;
import ru.skypro.homework.services.AdsService;
import ru.skypro.homework.services.impl.ImageServiceImpl;
import javax.validation.Valid;
import java.io.IOException;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class AdsController {
    private final AdsService adsService;
    private final ImageServiceImpl imageService;

    //Получение информации об объявлении
    @GetMapping("/{id}")
    public ResponseEntity<FullAds> getFullAd(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(adsService.getAdsById(id));
    }

    //Получение всех объявлений
    @GetMapping
    public ResponseWrapper<AdsDTO> getAllAds() {
        return ResponseWrapper.of(adsService.getAllAds());
    }

    //Получение объявления авторизованного пользователя
    @GetMapping("/me")
    public ResponseWrapper<AdsDTO> getAdsMe(Authentication authentication) {
        return ResponseWrapper.of(adsService.getAdsMe(authentication));
    }

    //Получение изображения по идентификатору
    @Operation(hidden = true)
    @GetMapping(value = "/image/{id}", produces = MediaType.MULTIPART_FORM_DATA_VALUE)
    public byte[] getImage(@PathVariable("id") Integer id) {
        return imageService.getImageById(id).getData();
    }

    //Добавление объявления
    @PostMapping(consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<AdsDTO> addAds(@RequestPart("image") MultipartFile imageFile,
                                         @Valid
                                         @RequestPart("properties") CreateAds createAds,
                                         Authentication authentication) throws IOException {
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(adsService.addAds(imageFile, createAds, authentication));
    }

    //Обновление информации об объявлении
    @PatchMapping("/{id}")
    public ResponseEntity<AdsDTO> updateAds(@PathVariable("id") Integer id,
                                            @RequestBody CreateAds createAds) {
        return ResponseEntity.ok(adsService.updateAds(id, createAds));
    }

    //Обновление картинки объявления
    @PatchMapping(value = "/{id}/image", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public ResponseEntity<?> updateAdsImage(@PathVariable("id") Integer id,
                                            @RequestPart("image") MultipartFile imageFile) throws IOException {
        adsService.updateAdsImage(id, imageFile);
        return ResponseEntity.ok().build();
    }

    //Удаление объявления
    @DeleteMapping("/{id}")
    public ResponseEntity<?> removeAds(@PathVariable("id") Integer id) {
        adsService.removeAdsById(id);
        return ResponseEntity.ok().build();
    }

}
