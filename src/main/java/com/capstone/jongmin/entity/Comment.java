package com.capstone.jongmin.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Getter
@Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Comment extends BaseEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "post_id")
  private Post post;

  @Column(nullable = false)
  private String content;

  @ManyToOne
  @OnDelete(action = OnDeleteAction.CASCADE)
  @JoinColumn(name = "parent_comment_id")
  private Comment parentComment;

  // 부모 댓글이 삭제될 때 자식 댓글도 함께 삭제되도록 설정
  @OneToMany(mappedBy = "parentComment", cascade = CascadeType.ALL, orphanRemoval = true)
  private List<Comment> childComments = new ArrayList<>();

  // 부모 댓글 설정 메서드
  public void setParentComment(Comment parentComment) {
    this.parentComment = parentComment;
    if (parentComment != null) {
      parentComment.addChildComment(this);
    }
  }

  // 자식 댓글 추가 메서드
  public void addChildComment(Comment childComment) {
    childComments.add(childComment);
    childComment.setParentComment(this);
  }

  @Builder
  public Comment(String content){
    this.content = content;
  }

  public void update(String content){
    this.content = content;
  }
}
