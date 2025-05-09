package com.example.walkingclub.controller;

import com.example.walkingclub.dto.ReplyRequestDto;
import com.example.walkingclub.dto.ReplyResponseDto;
import com.example.walkingclub.dto.View;
import com.example.walkingclub.service.ReplyService;
import com.fasterxml.jackson.annotation.JsonView;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
@RequiredArgsConstructor
@RequestMapping("/reply")
public class ReplyController {

    private final ReplyService replyService;

    // 대댓글 저장
    @PostMapping
    @JsonView(View.Create.class)
    public ResponseEntity<ReplyResponseDto> createReply(
            @Validated(View.Content.class)
            @RequestBody ReplyRequestDto requestDto
    ) {
        ReplyResponseDto responseDto = replyService.createReply(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    // 대댓글 조회
    @GetMapping
    @JsonView(View.Gets.class)
    public ResponseEntity<List<ReplyResponseDto>> getReplies(
            @Validated(View.Id.class)
            @RequestBody ReplyRequestDto requestDto
    ) {
        List<ReplyResponseDto> responseDto = replyService.getReplies(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 대댓글 수정
    @PutMapping("/{id}")
    @JsonView(View.Update.class)
    public ResponseEntity<ReplyResponseDto> updateReply(
            @PathVariable Long id,
            @Validated(View.Contents.class)
            @RequestBody ReplyRequestDto requestDto
    ) {
        ReplyResponseDto responseDto = replyService.updateReply(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 대댓글 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteReply(@PathVariable Long id) {
        replyService.deleteReply(id);
        return ResponseEntity.noContent().build();
    }
}
