package com.example.walkingclub.entity;

import com.example.walkingclub.dto.CommentRequestDto;
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
public class Comment extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "commentId")
    private Long id;                    // 댓글 아이디

    @JoinColumn(name = "writerId", nullable = false)
    private Long writerId;              // 작성자 아이디

    @ManyToOne
    @JoinColumn(name = "scheduleId", nullable = false)
    private Schedule scheduleId;            // 일정 아이디

    @Column
    private String comment;             // 댓글 내용

    // 댓글 저장
    public static Comment of(Long writerId, Schedule scheduleId, CommentRequestDto requestDto) {
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
