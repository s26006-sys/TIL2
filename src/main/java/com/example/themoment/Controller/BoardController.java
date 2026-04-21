package com.example.themoment.Controller;

import com.example.themoment.DTO.RequestDTO;
import com.example.themoment.DTO.ResponseDTO; // <--- 이 줄을 추가하세요!
import com.example.themoment.Entity.BoardEntity;
import com.example.themoment.Service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/gwaje")
@RequiredArgsConstructor
public class BoardController {

    private final BoardService boardService;

    @PostMapping("/create")
    public ResponseDTO create(@RequestBody RequestDTO requestDto) {
        return boardService.create(requestDto);
    }

    @GetMapping("/")
    public ResponseDTO.BoardListResponse findAll() {
        return boardService.findAll();
    }

    @GetMapping("/view/{id}")
    public ResponseDTO findById(@PathVariable Long id) {
        return boardService.findById(id);
    }

    @PatchMapping("/update/{id}")
    public ResponseDTO update(@PathVariable Long id, @RequestBody RequestDTO requestDto) {
        return boardService.update(id, requestDto);
    }

    @DeleteMapping("/remove/{id}")
    public void delete(@PathVariable Long id) {
        boardService.delete(id);
    }
}