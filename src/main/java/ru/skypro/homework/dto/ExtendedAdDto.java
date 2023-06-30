package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class ExtendedAdDto {
    Integer adId;
    String authorFirstName;
    String authorLastName;
    String description;
    String email;
    String imageReference;
    String phone;
    Integer price;
    String title;
}