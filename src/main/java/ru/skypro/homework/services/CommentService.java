package ru.skypro.homework.services;
import org.springframework.security.core.Authentication;
import ru.skypro.homework.dto.CommentDTO;
import java.util.List;

public interface CommentService {
    CommentDTO addAdsComment(Integer id, CommentDTO commentDTO,
                             Authentication authentication);

    void deleteAdsComment(Integer adId, Integer commentId);

    CommentDTO updateComments(Integer adId, Integer commentId, CommentDTO commentDTO);

    List<CommentDTO> getComments(Integer id);

    CommentDTO getCommentById(Integer id);

}
