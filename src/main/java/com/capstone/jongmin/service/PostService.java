package com.capstone.jongmin.service;


import com.capstone.jongmin.dto.PostRequest;
import com.capstone.jongmin.entity.Board;
import com.capstone.jongmin.entity.Post;
import com.capstone.jongmin.repository.BoardRepository;
import com.capstone.jongmin.repository.PostRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;
  private final BoardRepository boardRepository;

  // CREATE
  public Post savePost(Long boardId, Post post){
    Board board = boardRepository.findById(boardId).orElseThrow(()-> new IllegalArgumentException("not found :" + boardId));
    Post savePost = new Post(post.getTitle(),post.getContent(),board);
    return postRepository.save(savePost);
  }

  // READ
  public List<Post> findAll() {
    return postRepository.findAll();
  }

  public Post findById(Long id) {
    return postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found: "+id));
  }

  // UPDATE
  @Transactional
  public Post updatePost(Post post,Long id) {
    Post findPost = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(("not found: ")+id));
    findPost.update(post.getTitle(),post.getContent());

    return findPost;
  }
  // DELETE
  public void deletePost(Long id) {
    postRepository.deleteById(id);
  }

  public Page<Post> getPostByBoardId(Long boardId, Pageable pageable) {
    return postRepository.findByBoardId(boardId, pageable);
  }

  public Page<Post> searchPosts(Long boardId, String keyword, Pageable pageable) {
    return postRepository.findByBoardIdAndTitleContaining(boardId, keyword, pageable);
  }
}
