package com.capstone.jongmin.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Board{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id",updatable = false)
  private Long id;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;

  @Builder
  public Board(String title, String content){
    this.title = title;
    this.content = content;
  }

}
