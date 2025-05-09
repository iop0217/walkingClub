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
public class ReplyRequestDto {

    @NotNull(groups = {View.Content.class, View.Id.class})
    private Long commentId;     // 댓글 아이디

    @Size(max = 1000)
    @NotBlank(groups = {View.Content.class, View.Contents.class})
    private String reply;       // 대댓글 내용
}
