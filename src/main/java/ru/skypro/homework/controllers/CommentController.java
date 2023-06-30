package ru.skypro.homework.controllers;

import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;
import ru.skypro.homework.dto.CommentDto;
import ru.skypro.homework.services.impl.CommentService;

import java.util.List;

@ControllerAdvice
@RestController
@CrossOrigin(value = "http://localhost:3000")
@RequestMapping("/ads")
public class CommentController {
    private final CommentService commentService;

    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @ExceptionHandler({HttpClientErrorException.Unauthorized.class, HttpClientErrorException.NotFound.class})
    @GetMapping("/{id}/comments")
    public List<CommentDto> getAdComments(@PathVariable Integer id) {
        return commentService.getAdComments(id);
    }

    @ExceptionHandler({HttpClientErrorException.Unauthorized.class, HttpClientErrorException.NotFound.class})
    @PostMapping("/{id}/comments")
    public CommentDto createComment(@RequestBody String text, @PathVariable Integer id) {
        return commentService.createComment(text, id);
    }

    @ExceptionHandler({HttpClientErrorException.Unauthorized.class, HttpClientErrorException.Forbidden.class, HttpClientErrorException.NotFound.class})
    @DeleteMapping("/{adId}/comments/{commentId}")
    public void deleteComment(@PathVariable Integer adId, @PathVariable Integer commentId) {
        commentService.deleteComment(adId, commentId);
    }

    @ExceptionHandler({HttpClientErrorException.Unauthorized.class, HttpClientErrorException.Forbidden.class, HttpClientErrorException.NotFound.class})
    @PatchMapping("/{adId}/comments/{commentId}")
    public CommentDto updateComment(@RequestBody String text, @PathVariable Integer adId, @PathVariable Integer commentId) {
        return commentService.updateComment(text, adId, commentId);
    }
}