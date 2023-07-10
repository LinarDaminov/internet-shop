package ru.skypro.homework.controllers;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;
import ru.skypro.homework.dto.AdsCommentDTO;
import ru.skypro.homework.dto.ResponseWrapper;
import ru.skypro.homework.services.CommentService;

@CrossOrigin(value = "http://localhost:3000")
@RestController
@RequestMapping("/ads")
@RequiredArgsConstructor
public class CommentController {

    private final CommentService commentService;

    //Получение комментария объявления
    @GetMapping("/{id}/comments")
    public ResponseWrapper<AdsCommentDTO> getComments(@PathVariable("id") Integer id) {
        return ResponseWrapper.of(commentService.getComments(id));
    }

    //Добавление нового комментария к объявлению
    @PostMapping("/{id}/comments")
    public ResponseEntity<AdsCommentDTO> addAdsComment(@PathVariable("id") Integer id,
                                                       @RequestBody AdsCommentDTO adsCommentDTO,
                                                       Authentication authentication) {
        return ResponseEntity.ok(commentService.addAdsComment(id, adsCommentDTO, authentication));
    }

    //Удаление комментария
    @DeleteMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<?> deleteAdsComment(@PathVariable("adId") Integer adId,
                                              @PathVariable("commentId") Integer commentId) {
        commentService.deleteAdsComment(adId, commentId);
        return ResponseEntity.ok().build();
    }

    //Обновление комментария
    @PatchMapping("/{adId}/comments/{commentId}")
    public ResponseEntity<AdsCommentDTO> updateComments(@PathVariable("adId") Integer adId,
                                                        @PathVariable("commentId") Integer commentId,
                                                        @RequestBody AdsCommentDTO adsCommentDTO) {
        return ResponseEntity.ok(commentService.updateComments(adId, commentId, adsCommentDTO));
    }
}
