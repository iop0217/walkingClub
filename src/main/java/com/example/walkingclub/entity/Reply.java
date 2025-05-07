package com.example.walkingclub.entity;

import com.example.walkingclub.dto.ReplyRequestDto;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reply {

    @Id
    @Column(name = "replyId")
    private Long id;                    // 대댓글 아이디

    @JoinColumn(nullable = false)
    private Long writerId;              // 작성자 아이디

    @JoinColumn(nullable = false)
    private Long commentId;             // 댓글 아이디

    private String comment;             // 댓글 내용
    private String reply;               // 대댓글 내용
    private LocalDateTime createdAt;    // 대댓글 작성일
    private LocalDateTime updatedAt;    // 대댓글 수정일

    // 대댓글 저장
    public static Reply of(Long writerId, Long commentId, ReplyRequestDto requestDto) {
        return Reply.builder()
                .writerId(writerId)
                .commentId(commentId)
                .reply(requestDto.getReply())
                .build();
    }
}
