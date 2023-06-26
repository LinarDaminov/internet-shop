package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class AdDto {
    Integer userId;
    String imageReference;
    Integer adId;
    Integer price;
    String title;
}