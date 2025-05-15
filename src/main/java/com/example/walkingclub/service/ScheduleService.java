package com.example.walkingclub.service;

import com.example.walkingclub.dto.ScheduleListResponseDto;
import com.example.walkingclub.dto.ScheduleRequestDto;
import com.example.walkingclub.dto.ScheduleResponseDto;
import com.example.walkingclub.entity.Comment;
import com.example.walkingclub.entity.Schedule;
import com.example.walkingclub.exception.ServiceException;
import com.example.walkingclub.repository.CommentRepository;
import com.example.walkingclub.repository.ReplyRepository;
import com.example.walkingclub.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;
    private final CommentRepository commentRepository;
    private final ReplyRepository replyRepository;

    // 일정 생성
    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.save(requestDto.toEntity());
        return ScheduleResponseDto.toDto(schedule);
    }

    // 일정 전체 조회
    @Transactional(readOnly = true)
    public List<ScheduleListResponseDto> getSchedules() {
        return scheduleRepository.findCommentCount();
    }

    // 일정 단건 조회
    @Transactional(readOnly = true)
    public ScheduleResponseDto getSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ServiceException("해당 일정을 찾을 수 없습니다"));
        List<Comment> comments = commentRepository.findBySchedule(schedule);
        return ScheduleResponseDto.toDto(schedule, comments);
    }

    // 일정 수정
    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ServiceException("해당 일정을 찾을 수 없습니다"));
        schedule.update(requestDto.getTitle(), requestDto.getContent());
        return ScheduleResponseDto.toDto(schedule);
    }

    // 일정 삭제
    @Transactional
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id)
                .orElseThrow(() -> new ServiceException("해당 일정을 찾을 수 없습니다"));
        replyRepository.deleteBySchedule(schedule);
        commentRepository.deleteBySchedule(schedule);
        scheduleRepository.delete(schedule);
    }
}
