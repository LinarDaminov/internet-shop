package ru.skypro.homework.services;
import org.springframework.security.core.Authentication;
import ru.skypro.homework.dto.AdsCommentDTO;
import ru.skypro.homework.model.Comment;
import java.util.List;

public interface CommentService {
    AdsCommentDTO addAdsComment(Integer id, AdsCommentDTO adsCommentDTO,
                                Authentication authentication);

    void deleteAdsComment(Integer adId, Integer commentId);

    AdsCommentDTO updateComments(Integer adId, Integer commentId, AdsCommentDTO adsCommentDTO);

    List<AdsCommentDTO> getComments(Integer id);

    Comment getCommentById(Integer id);

}
