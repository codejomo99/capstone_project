package com.capstone.jongmin.dto;

import com.capstone.jongmin.entity.Comment;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentRequest {

  private String content;

  public Comment toEntity(){
    return Comment.builder()
        .content(content)
        .build();
  }
}
