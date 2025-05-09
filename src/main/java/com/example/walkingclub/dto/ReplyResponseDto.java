package com.example.walkingclub.dto;

import com.example.walkingclub.entity.Reply;
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
public class ReplyResponseDto {

    @JsonView(View.All.class)
    private Long writerId;              // 작성자 아아디

    @JsonView(View.Gets.class)
    private Long scheduleId;          // 일정 아이디

    @JsonView({View.Create.class, View.Gets.class})
    private Long replyId;               // 대댓글 아이디

    @JsonView(View.Gets.class)
    private String comments;             // 댓글 내용

    @JsonView(View.All.class)
    private String reply;               // 대댓글 내용

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(View.All.class)
    private LocalDateTime createdAt;    // 작성일

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(View.All.class)
    private LocalDateTime updatedAt;    // 수정일

    public static ReplyResponseDto toDto(Reply reply) {
        return new ReplyResponseDto(
                reply.getWriterId(),
                reply.getSchedule().getId(),
                reply.getId(),
                reply.getComments(),
                reply.getReply(),
                reply.getCreatedAt(),
                reply.getUpdatedAt()
        );
    }
}
