package com.example.themoment.Controller;

import com.example.themoment.Entity.BoardEntity;
import com.example.themoment.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gwaje")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create")
    public BoardEntity create(@RequestBody BoardEntity board) {
        return boardService.create(board);
    }

    @GetMapping("/")
    public List<BoardEntity> findAll() {
        return boardService.findAll();
    }

    @GetMapping("/view/{id}")
    public BoardEntity findById(@PathVariable Long id) {
        return boardService.findById(id);
    }

    @DeleteMapping("/remove/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }

    @PatchMapping("/update/{id}")
    public BoardEntity update(@PathVariable Long id,
                              @RequestBody BoardEntity board) {
        return boardService.update(id, board);
    }
}