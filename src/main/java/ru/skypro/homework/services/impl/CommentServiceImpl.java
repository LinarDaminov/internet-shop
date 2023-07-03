package ru.skypro.homework.services.impl;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.skypro.homework.dto.CommentDTO;
import ru.skypro.homework.services.CommentService;
import java.util.List;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
    @Override
    public CommentDTO addAdsComment(Integer id, CommentDTO commentDTO, Authentication authentication) {
        return null;
    }

    @Override
    public void deleteAdsComment(Integer adId, Integer commentId) {

    }

    @Override
    public CommentDTO updateComments(Integer adId, Integer commentId, CommentDTO commentDTO) {
        return null;
    }

    @Override
    public List<CommentDTO> getComments(Integer id) {
        return null;
    }

    @Override
    public CommentDTO getCommentById(Integer id) {
        return null;
    }
}
