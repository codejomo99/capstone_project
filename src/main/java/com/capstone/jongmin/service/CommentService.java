package com.capstone.jongmin.service;


import com.capstone.jongmin.entity.Comment;
import com.capstone.jongmin.repository.CommentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {
  private final CommentRepository commentRepository;

  public Comment saveComment(Comment comment){
    return commentRepository.save(comment);
  }

  public List<Comment> findAllComment(){
    return commentRepository.findAll();
  }

  public Comment updateComment(Long id, Comment comment){
    Comment findComment = commentRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found: "+id));
    findComment.update(comment.getContent());

    return findComment;
  }

  public void deleteComment(Long id){
    commentRepository.deleteById(id);
  }
}
