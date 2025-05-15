package com.example.walkingclub.service;
import com.example.walkingclub.dto.CommentRequestDto;
import com.example.walkingclub.dto.CommentResponseDto;
import com.example.walkingclub.entity.Comment;
import com.example.walkingclub.entity.Schedule;
import com.example.walkingclub.exception.ServiceException;
import com.example.walkingclub.repository.CommentRepository;
import com.example.walkingclub.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    // 댓글 저장
    @Transactional
    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        Schedule findSchedule = scheduleRepository.findById(requestDto.getScheduleId())
                .orElseThrow(() -> new ServiceException("해당 일정을 찾을 수 없습니다"));
        Comment create = Comment.of(findSchedule.getWriterId(), findSchedule,requestDto);
        Comment comment = commentRepository.save(create);
        return CommentResponseDto.toDto(comment);
    }

    // 댓글 조회
    @Transactional(readOnly = true)
    public List<CommentResponseDto> getComments(CommentRequestDto requestDto) {
        Schedule findSchedule = scheduleRepository.findById(requestDto.getScheduleId())
                .orElseThrow(() -> new ServiceException("해당 일정을 찾을 수 없습니다"));
        List<Comment> comments = commentRepository.findBySchedule(findSchedule);
        return comments.stream()
                .map(CommentResponseDto::toDto)
                .collect(Collectors.toList());
    }

    // 댓글 수정
    @Transactional
    public CommentResponseDto updateComment(Long id, CommentRequestDto requestDto) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ServiceException("해당 댓글을 찾을 수 없습니다"));
        comment.update(requestDto.getComments());
        return CommentResponseDto.toDto(comment);
    }

    // 댓글 삭제
    @Transactional
    public void deleteComment(Long id) {
        Comment comment = commentRepository.findById(id)
                .orElseThrow(() -> new ServiceException("해당 댓글을 찾을 수 없습니다"));
        commentRepository.delete(comment);
    }
}
