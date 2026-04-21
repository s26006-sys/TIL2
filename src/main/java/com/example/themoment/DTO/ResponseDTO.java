package com.example.themoment.DTO;

import com.example.themoment.Entity.BoardEntity;

import java.util.List;

public record ResponseDTO(
        Long id,
        String title,
        String contents
) {
    public ResponseDTO(BoardEntity entity) {
        this(entity.getId(), entity.getTitle(), entity.getContents());
    }

    // 목록 조회 응답 규격 {"posts": [...]} 을 맞추기 위한 레코드
    public record BoardListResponse(List<ResponseDTO> posts) {}
}