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
public class Reply {

    @Id
    @Column(name = "replyId")
    private Long id;                    // 대댓글 아이디

    private String content;        // 대댓글 내용
    private LocalDateTime createdAt;    // 대댓글 작성일
    private LocalDateTime updatedAt;    // 대댓글 수정일
}
