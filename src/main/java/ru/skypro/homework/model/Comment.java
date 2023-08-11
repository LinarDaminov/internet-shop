package ru.skypro.homework.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;


import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.Instant;
import java.util.List;


@Entity
@Data
@Table
public class Comment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;


    private Instant createdAt;


    private String text;

    @ManyToOne(fetch = FetchType.LAZY)
    private Ads ads;

    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

}