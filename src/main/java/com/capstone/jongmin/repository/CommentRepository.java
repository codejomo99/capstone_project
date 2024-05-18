package com.capstone.jongmin.repository;

import com.capstone.jongmin.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment,Long> {

}
