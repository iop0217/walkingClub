package com.example.walkingclub.dto;

import com.example.walkingclub.entity.Reply;
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
public class ReplyResponseDto {
    private Long writerId;              // 작성자 아아디
    private Long replyId;               // 대댓글 아이디
    private String comments;             // 댓글 내용
    private String reply;               // 대댓글 내용

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;    // 작성일

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;    // 수정일

    public static ReplyResponseDto toDto(Reply reply) {
        return new ReplyResponseDto(
                reply.getWriterId(),
                reply.getId(),
                reply.getComments(),
                reply.getReply(),
                reply.getCreatedAt(),
                reply.getUpdatedAt()
        );
    }
}
