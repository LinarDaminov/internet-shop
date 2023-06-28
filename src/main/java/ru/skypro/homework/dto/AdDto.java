package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class AdDto {
    Integer userId;
    String avatarReference;
    Integer adId;
    Integer price;
    String title;
}