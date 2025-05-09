package com.example.walkingclub.entity;

import com.example.walkingclub.dto.ReplyRequestDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Reply extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "reply_id")
    private Long id;                    // 대댓글 아이디

    @JoinColumn(name = "writer_id", nullable = false)
    private Long writerId;              // 작성자 아이디

    @ManyToOne
    @JoinColumn(name = "comment_id", nullable = false)
    private Comment comment;            // 댓글 아이디

    @Column
    private String comments;            // 댓글 내용

    @Column
    private String reply;               // 대댓글 내용

    // 대댓글 저장
    public static Reply of(Long writerId, Comment comment, ReplyRequestDto requestDto) {
        return Reply.builder()
                .writerId(writerId)
                .comment(comment)
                .reply(requestDto.getReply())
                .build();
    }

    // 대댓글 수정
    public void update(String reply) {
        this.reply = reply;
    }
}
