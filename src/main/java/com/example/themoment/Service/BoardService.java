package com.example.themoment.Service;


import com.example.themoment.DTO.RequestDTO;
import com.example.themoment.DTO.ResponseDTO;
import com.example.themoment.Entity.BoardEntity;
import com.example.themoment.Repository.BoardRepository;
import org.springframework.transaction.annotation.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardService {
    private final BoardRepository boardRepository;

    @Transactional
    public ResponseDTO create(RequestDTO dto) {
        BoardEntity entity = boardRepository.save(dto.toEntity());
        return new ResponseDTO(entity);
    }

    @Transactional(readOnly = true)
    public ResponseDTO.BoardListResponse findAll() {
        List<ResponseDTO> posts = boardRepository.findAll().stream()
                .map(ResponseDTO::new)
                .toList();
        return new ResponseDTO.BoardListResponse(posts);
    }

    @Transactional(readOnly = true)
    public ResponseDTO findById(Long id) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));
        return new ResponseDTO(entity);
    }

    @Transactional
    public ResponseDTO update(Long id, RequestDTO dto) {
        BoardEntity entity = boardRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("게시글을 찾을 수 없습니다."));

        // 더티 체킹(Dirty Checking)을 이용한 수정
        entity.update(dto.title(), dto.contents());
        return new ResponseDTO(entity);
    }

    @Transactional
    public void delete(Long id) {
        boardRepository.deleteById(id);
    }
}