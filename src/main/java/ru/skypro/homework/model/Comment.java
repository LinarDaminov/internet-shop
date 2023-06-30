package ru.skypro.homework.model;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Comment {
    Integer userId;
    String userAvatarReference;
    String firstName;
    LocalDateTime dateOfCreation;
    Integer commentId;
    String text;
    Integer adId;
}