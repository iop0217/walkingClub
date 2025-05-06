package com.example.walkingclub.dto;

import com.example.walkingclub.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponseDto {
    private Long writerId;              // 작성자 아아디
    private Long scheduleId;            // 일정 아이디
    private Long commentId;             // 댓글 아이디
    private String title;               // 일정 제목
    private String content;             // 일정 내용
    private String comment;             // 댓글 내용
    private Long commentCount;          // 댓글 개수
    private LocalDateTime createdAt;    // 일정 작성일
    private LocalDateTime updatedAt;    // 일정 수정일

    // 일정 생성
    public static ScheduleResponseDto toDto(Schedule schedule) {
        return ScheduleResponseDto.builder()
                .scheduleId(schedule.getId())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .createdAt(schedule.getCreatedAt())
                .updatedAt(schedule.getUpdatedAt())
                .build();
    }
}
