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
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;

    @NotNull
    private Instant createdAt;

    @NotNull
    private String text;

    @ManyToOne(fetch = FetchType.EAGER)
    private Ads ads;

    @ManyToOne(fetch = FetchType.EAGER)
    private User author;

}