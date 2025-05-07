package com.example.walkingclub.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class ReplyRequestDto {

    @NotBlank
    private Long commentId;     // 댓글 아이디

    @NotBlank
    @Size(max = 1000)
    private String reply;       // 대댓글 내용
}
