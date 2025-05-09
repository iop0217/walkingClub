package com.example.walkingclub.dto;

import com.example.walkingclub.entity.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
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
    private Long writerId;              // 작성자 아이디
    private Long scheduleId;            // 일정 아이디
    private Long commentId;             // 댓글 아이디
    private String comments;            // 댓글 내용

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;    // 작성일

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;    // 수정일

    public static CommentResponseDto toDto(Comment comment) {
        return new CommentResponseDto(
                comment.getWriterId(),
                comment.getSchedule().getId(),
                comment.getId(),
                comment.getComments(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }
}
