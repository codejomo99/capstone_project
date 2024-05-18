package com.capstone.jongmin.dto;


import com.capstone.jongmin.entity.Post;
import com.capstone.jongmin.entity.studentenum.Department;
import com.capstone.jongmin.entity.studentenum.StudentId;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostRequest {
  private String title;
  private String content;


  public Post toEntity(){
    return Post.builder()
        .title(title)
        .content(content)
        .build();
  }
}
