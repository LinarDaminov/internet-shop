package ru.skypro.homework.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;
import javax.persistence.*;

@Entity
@Data
@Table
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private String mediaType;
    private Long fileSize;
    @Lob
    @Type(type="org.hibernate.type.BinaryType")
    private byte[] data;

}
