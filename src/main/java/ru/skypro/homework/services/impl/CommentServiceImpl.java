package ru.skypro.homework.services.impl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skypro.homework.dto.AdsCommentDTO;
import ru.skypro.homework.exceptions.CommentNotFoundException;
import ru.skypro.homework.mapping.AdsCommentMapping;
import ru.skypro.homework.model.Comment;
import ru.skypro.homework.repositories.CommentRepository;
import ru.skypro.homework.services.CommentService;
import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final UserServiceImpl userService;
    private final AdsServiceImpl adsService;
    @Override
    public AdsCommentDTO addAdsComment(Integer id, AdsCommentDTO adsCommentDTO, Authentication authentication) {
        return null;
    }

    @Override
    public void deleteAdsComment(Integer adId, Integer commentId) {
        log.debug("Delete comment with id: {} for ads with id: {}", commentId, adId);
        Comment comment = getAdsComment(commentId, adId);
        commentRepository.delete(comment);
        log.info("Comment removed successfully");

    }

    @Override
    public AdsCommentDTO updateComments(Integer adId, Integer commentId, AdsCommentDTO adsCommentDTO) {
        return null;
    }

    @Override
    public List<AdsCommentDTO> getComments(Integer id) {

        log.debug("Get comments for ads with id: {}", id);
        return commentRepository.findAllByAdsId(id)
                .stream()
                .map(AdsCommentMapping.INSTANSE::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public Comment getCommentById(Integer id) {
        log.debug("Get comment with id: {}", id);
        return commentRepository.findById(id).orElseThrow(CommentNotFoundException::new);
    }

    public Comment getAdsComment(Integer commentId, Integer adId) {
        log.debug("Get comment with id: {} for ads with id: {}", commentId, adId);
        return commentRepository.findByIdAndAdsId(commentId, adId).orElseThrow(CommentNotFoundException::new);
    }
}
