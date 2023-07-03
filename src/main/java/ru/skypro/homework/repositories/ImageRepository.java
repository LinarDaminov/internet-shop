package ru.skypro.homework.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.skypro.homework.model.Image;

import java.awt.*;

@Repository
public interface ImageRepository extends JpaRepository<Image, Integer> {
}
