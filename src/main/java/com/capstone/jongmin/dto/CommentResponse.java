package com.capstone.jongmin.dto;

import com.capstone.jongmin.entity.Board;
import com.capstone.jongmin.entity.Comment;
import lombok.Getter;

@Getter
public class CommentResponse {
  private final String content;

  public CommentResponse(Comment comment){
    content = comment.getContent();
  }
}
