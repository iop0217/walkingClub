package com.example.walkingclub.service;

import com.example.walkingclub.dto.ReplyRequestDto;
import com.example.walkingclub.dto.ReplyResponseDto;
import com.example.walkingclub.entity.Comment;
import com.example.walkingclub.entity.Reply;
import com.example.walkingclub.repository.CommentRepository;
import com.example.walkingclub.repository.ReplyRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReplyService {

    private final CommentRepository commentRepository;
    private final ReplyRepository replyRepository;

    // 대댓글 저장
    @Transactional
    public ReplyResponseDto createReply(ReplyRequestDto requestDto) {
        Comment findComment = commentRepository.findById(requestDto.getCommentId()).orElseThrow();
        Reply create = Reply.of(findComment.getWriterId(), findComment.getId(), requestDto);
        Reply reply = replyRepository.save(create);
        return ReplyResponseDto.toDto(reply);
    }

    // 대댓글 조회
    @Transactional(readOnly = true)
    public List<ReplyResponseDto> getReplies(ReplyRequestDto requestDto) {
        Comment findComment = commentRepository.findById(requestDto.getCommentId()).orElseThrow();
        List<Reply> replies = replyRepository.findByCommentId(findComment.getId());
        return replies.stream()
                .map(ReplyResponseDto::toDto)
                .collect(Collectors.toList());
    }
}
