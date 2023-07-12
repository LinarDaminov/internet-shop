package ru.skypro.homework.dto;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AdsDTO {
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int author;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String image;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private int pk;
    private int price;
    private String title;
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    private String description;
}