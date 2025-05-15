package com.example.walkingclub.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EntityListeners(AuditingEntityListener.class)
public class Schedule extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "schedule_id")
    private Long id;                    // 일정 아이디

    @Column(name = "writer_id", nullable = false)
    private Long writerId;              // 작성자 아이디

    @Column
    private String title;               // 일정 제목

    @Column
    private String content;             // 일정 내용

    @Column
    private Long commentCount;          // 댓글 개수

    // 작성자 아이디 랜덤
    @PrePersist
    public void ramdomWriter() {
        this.writerId = (long) (Math.random() * 999) + 1;
    }

    public void update(String title, String content) {
        this.title = title;
        this.content = content;
    }
}
