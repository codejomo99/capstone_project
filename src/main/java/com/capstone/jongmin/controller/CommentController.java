package com.capstone.jongmin.controller;


import com.capstone.jongmin.dto.CommentRequest;
import com.capstone.jongmin.dto.CommentResponse;
import com.capstone.jongmin.dto.CommentSaveRequest;
import com.capstone.jongmin.entity.Comment;
import com.capstone.jongmin.entity.Post;
import com.capstone.jongmin.service.CommentService;
import com.capstone.jongmin.service.PostService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
  private final CommentService commentService;
  private final PostService postService;
  @DeleteMapping("/comments/{id}")
  public ResponseEntity<Void> deleteComment(@PathVariable("id") Long id){
    commentService.deleteComment(id);
    return ResponseEntity.noContent().build();
  }

  @PostMapping("/comments/{id}/edit")
  public ResponseEntity<CommentResponse> updateComment(@PathVariable("id") Long id, @RequestBody CommentRequest request){
    Comment update = commentService.updateComment(id, request.toEntity());
    CommentResponse commentResponse = new CommentResponse(update);
    return ResponseEntity.ok(commentResponse);
  }

  @PostMapping("/comments")
  public ResponseEntity<CommentResponse> saveComment(@RequestParam("postId") Long postId, @RequestBody CommentSaveRequest request) {
    Post post = postService.findById(postId); // postId를 사용하여 Post 엔티티 조회
    Comment savedComment = commentService.saveComment(postId, request.toEntity(post));
    CommentResponse commentResponse = new CommentResponse(savedComment);
    return ResponseEntity.ok(commentResponse);
  }
}
