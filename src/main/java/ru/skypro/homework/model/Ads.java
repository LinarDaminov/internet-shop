package ru.skypro.homework.model;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Data
@Table
public class Ads {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private String title;

    private String description;

    @NotNull
    private Integer price;

    @ManyToOne(fetch = FetchType.LAZY)
    private User author;

    @OneToOne(cascade = CascadeType.ALL)
    private Image image;

    @JsonIgnore
    @OneToMany(mappedBy = "ads", cascade = CascadeType.ALL)
    private List<Comment> comments;
}
