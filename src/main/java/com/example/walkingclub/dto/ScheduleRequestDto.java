package com.example.walkingclub.dto;

import com.example.walkingclub.entity.Schedule;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ScheduleRequestDto {

    @NotBlank
    private String title;   // 일정 제목

    @Size(max = 1000)
    private String content; // 일정 내용

    // 매장 생성
    public Schedule toEntity() {
        return Schedule.builder()
                .title(this.title)
                .content(this.content)
                .build();
    }
}
