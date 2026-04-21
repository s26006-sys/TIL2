package com.example.themoment.DTO;

import com.example.themoment.Entity.BoardEntity;

public record RequestDTO(
        String title,
        String contents
) {
    public BoardEntity toEntity() {
        return BoardEntity.builder()
                .title(title)
                .contents(contents)
                .build();
    }
}