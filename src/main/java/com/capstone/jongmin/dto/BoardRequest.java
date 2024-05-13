package com.capstone.jongmin.dto;

import com.capstone.jongmin.entity.Board;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BoardRequest {
  public String name;
  public String description;


  public Board toEntity(){

    return Board.builder()
        .name(name)
        .description(description)
        .build();
  }
}
