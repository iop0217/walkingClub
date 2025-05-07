package com.example.walkingclub.controller;

import com.example.walkingclub.dto.ReplyRequestDto;
import com.example.walkingclub.dto.ReplyResponseDto;
import com.example.walkingclub.service.ReplyService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
    public ResponseEntity<ReplyResponseDto> createReply(@Valid @RequestBody ReplyRequestDto requestDto) {
        ReplyResponseDto responseDto = replyService.createReply(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    // 대댓글 조회
    @GetMapping
    public ResponseEntity<List<ReplyResponseDto>> getReplies(@Valid @RequestBody ReplyRequestDto requestDto) {
        List<ReplyResponseDto> responseDto = replyService.getReplies(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 대댓글 수정
    @PutMapping("/{id}")
    public ResponseEntity<ReplyResponseDto> updateReply(
            @PathVariable Long id,
            @Valid @RequestBody ReplyRequestDto requestDto
    ) {
        ReplyResponseDto responseDto = replyService.updateReply(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
