package com.capstone.jongmin.dto;

import com.capstone.jongmin.entity.Board;
import lombok.Getter;

@Getter
public class BoardResponse {
  private final Long id;
  private final String name;
  private final String description;

  public BoardResponse(Board board){
    id = board.getId();
    name = board.getName();
    description = board.getDescription();
  }
}
