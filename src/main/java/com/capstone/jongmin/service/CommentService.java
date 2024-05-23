package com.capstone.jongmin.service;


import com.capstone.jongmin.entity.Comment;
import com.capstone.jongmin.entity.Post;
import com.capstone.jongmin.repository.CommentRepository;
import com.capstone.jongmin.repository.PostRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
  private final PostRepository postRepository;
  private final CommentRepository commentRepository;

  public Comment saveComment(Long postId, Comment comment){
    Post post = postRepository.findById(postId).orElseThrow(()-> new IllegalArgumentException("not found : "+postId));
    Comment saveComment = new Comment(comment.getContent(), post);
    return commentRepository.save(saveComment);
  }

  public List<Comment> findByPostId(Long postId){
    return commentRepository.findByPostId(postId);
  }

  public Comment updateComment(Long id, Comment comment){
    Comment findComment = commentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found: "+id));
    findComment.update(comment.getContent());

    Comment savedComment = commentRepository.save(findComment); // 변경 사항 저장
    return savedComment;
  }

  public void deleteComment(Long id){
    commentRepository.deleteById(id);
  }
}
