package com.example.walkingclub.controller;

import com.example.walkingclub.dto.CommentRequestDto;
import com.example.walkingclub.dto.CommentResponseDto;
import com.example.walkingclub.service.CommentService;
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
@RequestMapping("/comment")
public class CommentController {

    private final CommentService commentService;

    // 댓글 저장
    @PostMapping
    public ResponseEntity<CommentResponseDto> createComment(@Valid @RequestBody CommentRequestDto requestDto) {
        CommentResponseDto responseDto = commentService.createComment(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    // 댓글 조회
    @GetMapping
    public ResponseEntity<List<CommentResponseDto>> getComments(@Valid @RequestBody CommentRequestDto requestDto) {
        List<CommentResponseDto> responseDto = commentService.getComments(requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 댓글 수정
    @PutMapping("/{id}")
    public ResponseEntity<CommentResponseDto> updateComment(
            @PathVariable Long id,
            @Valid @RequestBody CommentRequestDto requestDto
    ) {
        CommentResponseDto responseDto = commentService.updateComment(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }
}
