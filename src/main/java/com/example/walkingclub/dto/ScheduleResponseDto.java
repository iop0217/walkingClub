package com.example.walkingclub.dto;

import com.example.walkingclub.entity.Schedule;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
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

    @JsonView({Views.All.class})
    private Long writerId;              // 작성자 아아디

    @JsonView({Views.Create.class, Views.Gets.class})
    private Long scheduleId;            // 일정 아이디

    @JsonView(Views.Get.class)
    private Long commentId;             // 댓글 아이디

    @JsonView({Views.All.class})
    private String title;               // 일정 제목

    @JsonView({Views.Create.class, Views.Get.class, Views.Update.class})
    private String content;             // 일정 내용

    @JsonView(Views.Get.class)
    private String comment;             // 댓글 내용

    @JsonView(Views.Gets.class)
    private Long commentCount;          // 댓글 개수

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView({Views.All.class})
    private LocalDateTime createdAt;    // 작성일

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView({Views.All.class})
    private LocalDateTime updatedAt;    // 수정일

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
