package com.capstone.jongmin.repository;

import com.capstone.jongmin.entity.Comment;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {
  List<Comment> findByPostId(Long postId);
}
