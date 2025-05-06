package com.example.walkingclub.dto;

import com.example.walkingclub.entity.Comment;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CommentResponseDto {
    private Long writerId;
    private Long scheduleId;
    private Long commentId;
    private String comment;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 댓글 생성
    public static CommentResponseDto toDto(Comment comment) {
        return new CommentResponseDto(
                comment.getWriterId(),
                comment.getScheduleId(),
                comment.getId(),
                comment.getComment(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }
}
