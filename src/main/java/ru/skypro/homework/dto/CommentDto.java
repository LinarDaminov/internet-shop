package ru.skypro.homework.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class CommentDto {
    Integer userId;
    String userAvatarReference;
    String firstName;
    LocalDateTime dateOfCreation;
    Integer commentId;
    String text;
}