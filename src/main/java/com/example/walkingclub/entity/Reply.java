package com.example.walkingclub.entity;

import com.example.walkingclub.dto.ReplyRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reply {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "replyId")
    private Long id;                    // 대댓글 아이디

    @JoinColumn(name = "writerId", nullable = false)
    private Long writerId;              // 작성자 아이디

    @ManyToOne
    @JoinColumn(name = "commentId", nullable = false)
    private Comment commentId;             // 댓글 아이디

    @Column
    private String comment;             // 댓글 내용

    @Column
    private String reply;               // 대댓글 내용

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;    // 대댓글 작성일

    @LastModifiedDate
    @Column
    private LocalDateTime updatedAt;    // 대댓글 수정일

    // 대댓글 저장
    public static Reply of(Long writerId, Comment commentId, ReplyRequestDto requestDto) {
        return Reply.builder()
                .writerId(writerId)
                .commentId(commentId)
                .reply(requestDto.getReply())
                .build();
    }

    // 대댓글 수정
    public void update(String reply) {
        this.reply = reply;
    }
}
