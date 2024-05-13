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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Post extends BaseEntity{

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id",updatable = false)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "board_id", nullable = false)
  @OnDelete(action = OnDeleteAction.CASCADE)
  private Board board;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @Enumerated(EnumType.STRING)
  private Department department;

  @Enumerated(EnumType.STRING)
  @Column(name = "student_id")
  private StudentId studentId;

  @Column(nullable = false)
  private String title;

  @Column(nullable = false)
  private String content;

  @Column(name = "like_count")
  private int likeCount;

  @Column(name = "search_allowed")
  private boolean searchAllowed;

  @Column(name = "comment_allowed")
  private boolean commentAllowed;

  @Builder
  public Post(String title, String content){
    this.title = title;
    this.content = content;
  }

  @Builder
  public Post(String title, String content, int likeCount, boolean searchAllowed, boolean commentAllowed, Department department, StudentId studentId, User user, Board board) {
    this.title = title;
    this.content = content;
    this.likeCount = likeCount;
    this.searchAllowed = searchAllowed;
    this.commentAllowed = commentAllowed;
    this.department = department;
    this.studentId = studentId;
    this.user = user;
    this.board = board;
  }

}
