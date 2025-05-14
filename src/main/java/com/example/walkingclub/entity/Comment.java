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
    @Column(name = "comment_id")
    private Long id;                    // 댓글 아이디

    @JoinColumn(name = "writer_id", nullable = false)
    private Long writerId;              // 작성자 아이디

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "schedule_id", nullable = false)
    private Schedule schedule;          // 일정 아이디

    @Column
    private String comments;            // 댓글 내용

    public static Comment of(Long writerId, Schedule schedule, CommentRequestDto requestDto) {
        return Comment.builder()
                .writerId(writerId)
                .schedule(schedule)
                .comments(requestDto.getComments())
                .build();
    }

    // 댓글 수정
    public void update(String comment) {
        this.comments = comment;
    }
}
