package com.example.walkingclub.service;
import com.example.walkingclub.dto.CommentRequestDto;
import com.example.walkingclub.dto.CommentResponseDto;
import com.example.walkingclub.entity.Comment;
import com.example.walkingclub.entity.Schedule;
import com.example.walkingclub.repository.CommentRepository;
import com.example.walkingclub.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CommentService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;

    // 댓글 생성
    public CommentResponseDto createComment(CommentRequestDto requestDto) {
        Schedule findSchedule = scheduleRepository.findById(requestDto.getScheduleId()).orElseThrow();
        Comment create = Comment.of(findSchedule.getWriterId(), findSchedule.getId(), requestDto);
        Comment comment = commentRepository.save(create);
        return CommentResponseDto.toDto(comment);
    }
}
