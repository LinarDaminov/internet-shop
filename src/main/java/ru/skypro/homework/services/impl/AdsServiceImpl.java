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
import ru.skypro.homework.exceptions.AdsNotFoundException;
import ru.skypro.homework.mapping.AdsMapping;
import ru.skypro.homework.model.Ads;
import ru.skypro.homework.model.Image;
import ru.skypro.homework.model.User;
import ru.skypro.homework.repositories.AdsRepository;
import ru.skypro.homework.services.AdsService;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class AdsServiceImpl implements AdsService {

    private final UserServiceImpl userService;
    private final AdsRepository adsRepository;
    private final ImageServiceImpl imageService;

    @Override
    public AdsDTO addAds(MultipartFile imageFile, CreateAds createAds, Authentication authentication) throws IOException {
        log.debug("Ad ads");

        if (createAds.getTitle() == null || createAds.getTitle().isBlank()
                || createAds.getDescription() == null || createAds.getDescription().isBlank()
                || createAds.getPrice() == null) throw new IllegalArgumentException();

        Ads ads = AdsMapping.INSTANCE.toEntity(createAds);
        User user = userService.getUserByUsername(authentication.getName());
        ads.setAuthor(user);
        Image image = imageService.uploadImage(imageFile);
        ads.setImage(image);
        return AdsMapping.INSTANCE.toDTO(adsRepository.save(ads));
    }
    @Override
    public List<AdsDTO> getAllAds() {

        log.debug("Get all ads");
        return adsRepository.findAll()
                .stream()
                .map(AdsMapping.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public void removeAdsById(Integer id) {
        log.debug("Removing ads by id: {}", id);
        Ads ads = findAdsById(id);
        adsRepository.delete(ads);
        log.info("Ads removed successfully");
    }

    @Override
    public FullAds getAdsById(Integer id) {

        log.debug("Getting ads by id: {}", id);
        return AdsMapping.INSTANCE.toFullAds(findAdsById(id));
    }

    @Override
    public List<AdsDTO> getAdsMe(Authentication authentication) {

        log.debug("Get ads by author {}", authentication.getName());
        return adsRepository.
                findAllByAuthorId(userService.getUserByUsername(authentication.getName()).getId())
                .stream()
                .map(AdsMapping.INSTANCE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public AdsDTO updateAds(Integer id, CreateAds createAds) {

        log.debug("Update ads by id: {}", id);

        if (createAds.getTitle() == null || createAds.getTitle().isBlank()
                || createAds.getDescription() == null || createAds.getDescription().isBlank()
                || createAds.getPrice() == null) throw new IllegalArgumentException();

        Ads ads = findAdsById(id);
        ads.setTitle(createAds.getTitle());
        ads.setDescription(createAds.getDescription());
        ads.setPrice(createAds.getPrice());
        adsRepository.save(ads);
        log.info("Ads details updated for ads: {}", ads.getTitle());
        return AdsMapping.INSTANCE.toDTO(ads);
    }

    @Override
    public void updateAdsImage(Integer id, MultipartFile imageFile) throws IOException {
        log.debug("Update ads image by id: {}", id);
        Ads ads = findAdsById(id);
        if (ads.getImage() != null) {
            imageService.remove(ads.getImage());
        }
        ads.setImage(imageService.uploadImage(imageFile));
        adsRepository.save(ads);
        log.debug("Avatar updated for ads: {}", ads.getTitle());

    }

    public Ads findAdsById(Integer id) {
        log.debug("Finding ads by id: {}", id);
        return adsRepository.findById(id).orElseThrow(AdsNotFoundException::new);
    }
}
