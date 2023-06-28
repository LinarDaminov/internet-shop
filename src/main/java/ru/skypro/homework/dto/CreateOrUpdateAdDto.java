package ru.skypro.homework.dto;

import lombok.Data;

@Data
public class CreateOrUpdateAdDto {
    String title;
    String description;
    Integer price;
}
