package com.example.walkingclub.dto;

import com.example.walkingclub.entity.Schedule;
import com.fasterxml.jackson.annotation.JsonFormat;
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

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime createdAt;    // 작성일

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private LocalDateTime updatedAt;    // 수정일

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
