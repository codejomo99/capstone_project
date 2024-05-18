package com.capstone.jongmin.repository;

import com.capstone.jongmin.entity.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostRepository extends JpaRepository<Post, Long> {

}
