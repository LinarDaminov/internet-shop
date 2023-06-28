package ru.skypro.homework.utils;

import org.springframework.stereotype.Service;
import ru.skypro.homework.dto.AdDto;
import ru.skypro.homework.dto.CreateOrUpdateAdDto;
import ru.skypro.homework.dto.ExtendedAdDto;
import ru.skypro.homework.dto.UserDto;
import ru.skypro.homework.model.Ad;
import ru.skypro.homework.model.User;
import ru.skypro.homework.service.impl.AuthServiceImpl;

@Service
public class MappingUtils {
    public UserDto mapToUserDto(User entity) {
        UserDto dto = new UserDto();
        dto.setId(entity.getId());
        dto.setEmail(entity.getEmail());
        dto.setFirstName(entity.getFirstName());
        dto.setLastName(entity.getLastName());
        dto.setPhone(entity.getPhone());
        dto.setImage(entity.getAvatarReference());
        return dto;
    }

    public AdDto mapToAdDto(Ad entity) {
        AdDto dto = new AdDto();
        dto.setAdId(entity.getAdId());
        dto.setUserId(entity.getUserId());
        dto.setAvatarReference(entity.getAvatarReference());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());
        return dto;
    }

    public ExtendedAdDto mapToExtendedAdDto(Ad entity) {
        User user = AuthServiceImpl.getAuthUser();
        ExtendedAdDto dto = new ExtendedAdDto();
        dto.setAdId(entity.getAdId());
        dto.setAuthorFirstName(dto.getAuthorFirstName());
        dto.setAuthorLastName(dto.getAuthorLastName());
        dto.setEmail(user.getEmail());
        dto.setPhone(user.getPhone());
        dto.setTitle(entity.getTitle());
        dto.setPrice(entity.getPrice());
        dto.setDescription(entity.getDescription());
        dto.setImageReference(entity.getImageReference());
        return dto;
    }

    public Ad mapToAd(CreateOrUpdateAdDto dto, String imageReference) {
        User user = AuthServiceImpl.getAuthUser();
        Ad ad = new Ad();
        ad.setUserId(user.getId());
        ad.setAvatarReference(user.getAvatarReference());
        ad.setPrice(dto.getPrice());
        ad.setTitle(dto.getTitle());
        ad.setDescription(dto.getDescription());
        ad.setImageReference(imageReference);
        return ad;
    }
}