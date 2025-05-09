package com.example.walkingclub.dto;

import com.example.walkingclub.entity.Comment;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
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

    @JsonView(View.All.class)
    private Long writerId;              // 작성자 아이디

    @JsonView({View.Create.class, View.Gets.class})
    private Long commentId;             // 댓글 아이디

    @JsonView(View.All.class)
    private String comments;            // 댓글 내용

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(View.All.class)
    private LocalDateTime createdAt;    // 작성일

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(View.All.class)
    private LocalDateTime updatedAt;    // 수정일

    public static CommentResponseDto toDto(Comment comment) {
        return new CommentResponseDto(
                comment.getWriterId(),
                comment.getId(),
                comment.getComments(),
                comment.getCreatedAt(),
                comment.getUpdatedAt()
        );
    }
}
