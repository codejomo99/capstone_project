package com.capstone.jongmin.entity;


import com.capstone.jongmin.entity.studentenum.Department;
import com.capstone.jongmin.entity.studentenum.StudentId;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "users")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
public class User{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id",updatable = false)
  private Long id;

  @Column(name = "email", nullable = false, unique = true)
  private String email;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "name", nullable = false)
  private String userName;


  @Enumerated(EnumType.STRING)
  private Department department;

  @Enumerated(EnumType.STRING)
  @Column(name = "student_id")
  private StudentId studentId;


}
