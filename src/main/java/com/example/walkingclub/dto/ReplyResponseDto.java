package com.example.walkingclub.dto;

import com.example.walkingclub.entity.Reply;
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
    private Long writerId;
    private Long replyId;
    private String comment;
    private String reply;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;

    // 대댓글 저장
    public static ReplyResponseDto toDto(Reply reply) {
        return new ReplyResponseDto(
                reply.getWriterId(),
                reply.getId(),
                reply.getComment(),
                reply.getReply(),
                reply.getCreatedAt(),
                reply.getUpdatedAt()
        );
    }
}
