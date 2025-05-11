package com.example.walkingclub.dto;

import com.example.walkingclub.entity.Comment;
import com.example.walkingclub.entity.Schedule;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonView;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleResponseDto {

    @JsonView(View.All.class)
    private Long writerId;                      // 작성자 아아디

    @JsonView(View.Create.class)
    private Long scheduleId;                    // 일정 아이디

    @JsonView(View.Get.class)
    private Long commentId;                     // 댓글 아이디

    @JsonView(View.All.class)
    private String title;                       // 일정 제목

    @JsonView(View.All.class)
    private String content;                     // 일정 내용

    @JsonView(View.Get.class)
    private String comments;                    // 댓글 내용

    @JsonView(View.Get.class)
    private List<CommentResponseDto> commentList;  // 일정 목록

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(View.All.class)
    private LocalDateTime createdAt;    // 작성일

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @JsonView(View.All.class)
    private LocalDateTime updatedAt;    // 수정일

    public static ScheduleResponseDto toDto(Schedule schedule) {
        return ScheduleResponseDto.builder()
                .writerId(schedule.getWriterId())
                .scheduleId(schedule.getId())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .createdAt(schedule.getCreatedAt())
                .updatedAt(schedule.getUpdatedAt())
                .build();
    }

    public static ScheduleResponseDto toDto(Schedule schedule, List<Comment> commentList) {
        return ScheduleResponseDto.builder()
                .writerId(schedule.getWriterId())
                .scheduleId(schedule.getId())
                .title(schedule.getTitle())
                .content(schedule.getContent())
                .commentList(commentList.stream()
                        .map(CommentResponseDto::toDto)
                        .collect(Collectors.toList()))
                .createdAt(schedule.getCreatedAt())
                .updatedAt(schedule.getUpdatedAt())
                .build();
    }
}
