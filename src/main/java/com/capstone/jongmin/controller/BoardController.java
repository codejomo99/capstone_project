package com.capstone.jongmin.controller;


import com.capstone.jongmin.dto.BoardRequest;
import com.capstone.jongmin.dto.BoardResponse;
import com.capstone.jongmin.entity.Board;
import com.capstone.jongmin.service.BoardService;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BoardController {
  private final BoardService boardService;

  @GetMapping("/boards/create")
  public String moveCreateBoard() {
    return "createBoard";
  }

  @GetMapping("/boards/{id}/edit")
  public String moveEditBoard(@PathVariable("id") long id, Model model) {
    Board findBoard = boardService.findById(id);
    model.addAttribute("board",findBoard);
    return "editBoard";
  }

  @PostMapping("/boards/{id}/edit")
  public String editBoard(@PathVariable("id") long id, @ModelAttribute BoardRequest boardRequest) {
    System.out.println("Received edit request for board ID: " + id);
    System.out.println("Board name: " + boardRequest.getName());
    System.out.println("Board description: " + boardRequest.getDescription());

    boardService.update(id, boardRequest.toEntity());
    System.out.println("Board updated successfully");

    return "redirect:/boards";
  }


  @PostMapping("/boards/create")
  public String createBoard(@ModelAttribute BoardRequest boardRequest) {
    boardService.saveBoard(boardRequest.toEntity());
    return "redirect:/boards";
  }


  @GetMapping("/boards")
  public String getAllBoards(Model model) {
    List<BoardResponse> boards = boardService
        .findAll()
        .stream()
        .map(BoardResponse::new)
        .toList();

    model.addAttribute("boards", boards);
    return "boards";
  }

  @GetMapping("/boards/{id}")
  public String findByIdBoard(@PathVariable("id") long id, Model model){
    Board board = boardService.findById(id);
    model.addAttribute("board",board);

    return "board";
  }

  @DeleteMapping("/boards/{id}/delete")
  public String deleteBoard(@PathVariable("id") long id){
    boardService.deleteBoard(id);

    return "redirect:/boards";
  }
}
