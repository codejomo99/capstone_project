package com.capstone.jongmin.controller;


import com.capstone.jongmin.dto.CommentRequest;
import com.capstone.jongmin.dto.CommentResponse;
import com.capstone.jongmin.entity.Comment;
import com.capstone.jongmin.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CommentController {
  private final CommentService commentService;

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
}
