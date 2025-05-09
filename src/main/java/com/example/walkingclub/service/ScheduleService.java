package com.example.walkingclub.service;

import com.example.walkingclub.dto.ScheduleListResponseDto;
import com.example.walkingclub.dto.ScheduleRequestDto;
import com.example.walkingclub.dto.ScheduleResponseDto;
import com.example.walkingclub.entity.Schedule;
import com.example.walkingclub.repository.ScheduleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ScheduleService {

    private final ScheduleRepository scheduleRepository;

    // 일정 생성
    @Transactional
    public ScheduleResponseDto createSchedule(ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.save(requestDto.toEntity());
        return ScheduleResponseDto.toDto(schedule);
    }

    // 일정 전체 조회
    @Transactional(readOnly = true)
    public List<ScheduleListResponseDto> getSchedules() {
        List<Schedule> schedules = scheduleRepository.findAll();
        return schedules.stream().map(ScheduleListResponseDto::toDto).toList();
    }

    // 일정 단건 조회
    @Transactional(readOnly = true)
    public ScheduleResponseDto getSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow();
        return ScheduleResponseDto.toDto(schedule);
    }

    // 일정 수정
    @Transactional
    public ScheduleResponseDto updateSchedule(Long id, ScheduleRequestDto requestDto) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow();
        schedule.update(requestDto.getTitle(), requestDto.getContent());
        return ScheduleResponseDto.toDto(schedule);
    }

    // 일정 삭제
    @Transactional
    public void deleteSchedule(Long id) {
        Schedule schedule = scheduleRepository.findById(id).orElseThrow();
        scheduleRepository.delete(schedule);
    }
}
