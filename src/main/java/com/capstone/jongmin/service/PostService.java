package com.capstone.jongmin.service;


import com.capstone.jongmin.dto.PostRequest;
import com.capstone.jongmin.entity.Post;
import com.capstone.jongmin.repository.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostService {
  private final PostRepository postRepository;

  // CREATE
  public Post savePost(Post post){
    return postRepository.save(post);
  }

  // READ
  public List<Post> findAll() {
    return postRepository.findAll();
  }

  public Post findById(Long id) {
    return postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found: "+id));
  }

  // UPDATE
  public Post updatePost(Post post,Long id) {
    Post findPost = postRepository.findById(id).orElseThrow(()-> new IllegalArgumentException(("not found: ")+id));
    findPost.update(post.getTitle(),post.getContent());

    return findPost;
  }
  // DELETE
  public void deletePost(Long id) {
    postRepository.deleteById(id);
  }
}
