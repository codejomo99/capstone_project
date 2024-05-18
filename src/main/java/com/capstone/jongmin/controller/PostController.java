package com.capstone.jongmin.controller;


import com.capstone.jongmin.dto.PostRequest;
import com.capstone.jongmin.entity.Board;
import com.capstone.jongmin.entity.Comment;
import com.capstone.jongmin.entity.Post;
import com.capstone.jongmin.service.BoardService;
import com.capstone.jongmin.service.CommentService;
import com.capstone.jongmin.service.PostService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequiredArgsConstructor
public class PostController {

  private final PostService postService;
  private final CommentService commentService;
  private final BoardService boardService;

  @GetMapping("/posts/{id}")
  public String readPost(@PathVariable("id") long id, Model model) {
    Post post = postService.findById(id);
    List<Comment> comments = commentService.findAllComment();

    model.addAttribute("post",post);
    model.addAttribute("comments",comments);

    return "post";
  }

  @GetMapping("/posts/create")
  public String postCreateForm(@RequestParam("boardId") Long boardId, Model model){
    Board board = boardService.findById(boardId);
    model.addAttribute("board", board);
    model.addAttribute("boardId",boardId);
    return "createPost";
  }

  @GetMapping("/posts/{id}/edit")
  public String postUpdateForm(@PathVariable("id") long id, Model model) {
    Post findPost = postService.findById(id);
    model.addAttribute("post", findPost);
    return "editPost";
  }

  @PostMapping("/posts/create")
  public String createPost(@RequestParam("boardId") Long boardId, @ModelAttribute("post") PostRequest request){
    postService.savePost(boardId,request.toEntity());
    return "redirect:/boards/"+boardId;
  }

  @PostMapping("/posts/{id}/edit")
  public String editPost(@PathVariable("id") long id, @ModelAttribute PostRequest request){
    postService.updatePost(request.toEntity(),id);

    return "redirect:/posts/"+id;
  }

  @DeleteMapping("/posts/{id}")
  public void deletePost(@PathVariable("id") long id){
    postService.deletePost(id);
  }



}
