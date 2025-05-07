package com.example.walkingclub.entity;

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
public class Schedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "scheduleId")
    private Long id;                    // 일정 아이디

    @Column
    private Long writerId;              // 작성자 아이디

    @Column
    private String title;               // 일정 제목

    @Column
    private String content;             // 일정 내용

    @Column
    private Long commentCount;          // 댓글 개수

    @CreatedDate
    @Column(updatable = false)
    private LocalDateTime createdAt;    // 일정 작성일

    @LastModifiedDate
    @Column
    private LocalDateTime updatedAt;    // 일정 수정일

    // 일정 수정
    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
