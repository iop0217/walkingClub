package com.example.walkingclub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CommentRequestDto {

    @NotNull(groups = {View.Content.class, View.Id.class})
    private Long scheduleId;    // 일정 아이디

    @Size(max = 1000)
    @NotBlank(groups = {View.Content.class, View.Contents.class})
    private String comments;    // 댓글 내용
}