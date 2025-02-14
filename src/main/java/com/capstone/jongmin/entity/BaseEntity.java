package com.capstone.jongmin.entity;


import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import java.time.LocalDateTime;
import lombok.Getter;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


@Getter
@MappedSuperclass
public class BaseEntity {

  @CreatedDate
  @Column(name = "created_at")
  private LocalDateTime createAt;

  @LastModifiedDate
  @Column(name = "updated_at")
  private LocalDateTime updatedAt;
}
