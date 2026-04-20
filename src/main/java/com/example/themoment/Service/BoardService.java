package com.example.themoment.Service;


import com.example.themoment.Entity.BoardEntity;
import com.example.themoment.Repository.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public BoardEntity create(BoardEntity board) {
        return boardRepository.save(board);
    }

    public List<BoardEntity> findAll() {
        return boardRepository.findAll();
    }
    public BoardEntity findById(Long id) {
        return boardRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("게시글 없음"));
    }

    public void delete(Long id) {
        BoardEntity board = findById(id);
        boardRepository.delete(board);
    }

    public BoardEntity update(Long id, BoardEntity board) {
        board.setId(id);
        return boardRepository.save(board);
    }
}
