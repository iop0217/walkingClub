package com.example.walkingclub.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
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

    private String comment;             // 댓글 내용
    private LocalDateTime createdAt;    // 댓글 작성일
    private LocalDateTime updatedAt;    // 댓글 수정일
}
