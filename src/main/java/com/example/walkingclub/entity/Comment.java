package com.example.walkingclub.entity;

import com.example.walkingclub.dto.CommentRequestDto;
import jakarta.persistence.*;
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
public class Comment {

    @Id
    @Column(name = "commentId")
    private Long id;                    // 댓글 아이디

    @JoinColumn(nullable = false)
    private Long writerId;              // 작성자 아이디

    @JoinColumn(nullable = false)
    private Long scheduleId;            // 일정 아이디

    private String comment;             // 댓글 내용
    private LocalDateTime createdAt;    // 댓글 작성일
    private LocalDateTime updatedAt;    // 댓글 수정일

    // 댓글 저장
    public static Comment of(Long writerId, Long scheduleId, CommentRequestDto requestDto) {
        return Comment.builder()
                .writerId(writerId)
                .scheduleId(scheduleId)
                .comment(requestDto.getComment())
                .build();
    }

    // 댓글 수정
    public void update(String comment) {
        this.comment = comment;
    }
}
