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
public class CommentRequestDto {

    @NotBlank
    private Long scheduleId;

    @NotBlank
    @Size(max = 1000)
    private String comment; // 일정 내용
}
