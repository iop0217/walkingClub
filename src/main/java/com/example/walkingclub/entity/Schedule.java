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
public class Schedule {

    @Id
    @Column(name = "scheduleId")
    private Long id;                    // 일정 아이디

    private Long writerId;              // 작성자 아이디
    private String title;               // 일정 제목
    private String content;             // 일정 내용
    private Long commentCount;          // 댓글 개수
    private LocalDateTime createdAt;    // 일정 작성일
    private LocalDateTime updatedAt;    // 일정 수정일

    // 일정 수정
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
