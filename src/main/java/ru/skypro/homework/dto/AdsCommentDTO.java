package ru.skypro.homework.dto;
import lombok.Data;
@Data
public class AdsCommentDTO {
    private Integer author;
    private String authorImage;
    private String authorFirstName;
    private String createdAt;
    private Integer pk;
    private String text;
}