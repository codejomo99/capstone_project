package com.capstone.jongmin.dto;

import com.capstone.jongmin.entity.Comment;
import com.capstone.jongmin.entity.Post;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CommentSaveRequest {
  private String content;

  public Comment toEntity(Post post){
    return Comment.builder()
        .content(content)
        .post(post)
        .build();
  }
}
