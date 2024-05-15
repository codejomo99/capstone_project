package com.capstone.jongmin.service;


import com.capstone.jongmin.dto.BoardRequest;
import com.capstone.jongmin.entity.Board;
import com.capstone.jongmin.repository.BoardRepository;
import jakarta.transaction.Transactional;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BoardService {
  private final BoardRepository boardRepository;

  // Create
  public Board saveBoard(Board board) {
    return boardRepository.save(board);
  }

  // Read

  public List<Board> findAll() {
    return boardRepository.findAll();
  }

  public Board findById(Long id) {
    return boardRepository.findById(id).orElse(null);
  }

  // Update
  @Transactional
  public Board update(Long id, Board board) {
    Board findBoard = boardRepository.findById(id).orElseThrow(()-> new IllegalArgumentException("not found: " +id));
    findBoard.update(board.getName(),board.getDescription());

    boardRepository.save(findBoard);
    return findBoard;
  }

  // Delete
  public void deleteBoard(Long id) {
    boardRepository.deleteById(id);
  }

}
