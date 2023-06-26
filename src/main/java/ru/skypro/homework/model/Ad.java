package ru.skypro.homework.model;

import lombok.Data;

@Data
public class Ad {
    private Integer userId;
    private String imageReference;
    private Integer adId;
    private Integer price;
    private String title;
}
