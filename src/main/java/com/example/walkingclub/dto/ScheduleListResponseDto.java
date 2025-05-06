package com.example.walkingclub.dto;

import com.example.walkingclub.entity.Schedule;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleListResponseDto {
    private Long scheduleId;            // 일정 아이디
    private String title;               // 일정 제목
    private Long commentCount;          // 댓글 개수
    private LocalDateTime createdAt;    // 일정 작성일
    private LocalDateTime updatedAt;    // 일정 수정일

    // 일정 전체 조회
    public static ScheduleListResponseDto toDto(Schedule schedule) {
        return new ScheduleListResponseDto(
                schedule.getId(),
                schedule.getTitle(),
                schedule.getCommentCount(),
                schedule.getCreatedAt(),
                schedule.getUpdatedAt()
        );
    }
}
