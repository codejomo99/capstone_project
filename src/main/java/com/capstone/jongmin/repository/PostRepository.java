package com.capstone.jongmin.repository;

import com.capstone.jongmin.entity.Post;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {
  Page<Post> findByBoardId(long boardId, Pageable pageable);
  Page<Post> findByBoardIdAndTitleContaining(long boardId, String keyword, Pageable pageable);

}
