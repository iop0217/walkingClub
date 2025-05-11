package com.example.walkingclub.controller;

import com.example.walkingclub.dto.ScheduleListResponseDto;
import com.example.walkingclub.dto.ScheduleRequestDto;
import com.example.walkingclub.dto.ScheduleResponseDto;
import com.example.walkingclub.dto.View;
import com.example.walkingclub.service.ScheduleService;
import com.fasterxml.jackson.annotation.JsonView;
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
@RequestMapping("/schedule")
public class ScheduleController {

    private final ScheduleService scheduleService;

    // 일정 생성
    @PostMapping
    @JsonView(View.Create.class)
    public ResponseEntity<ScheduleResponseDto> createSchedule(@Valid @RequestBody ScheduleRequestDto requestDto) {
        ScheduleResponseDto responseDto = scheduleService.createSchedule(requestDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(responseDto);
    }

    // 일정 전체 조회
    @GetMapping
    public ResponseEntity<List<ScheduleListResponseDto>> getSchedules() {
        return ResponseEntity.ok(scheduleService.getSchedules());
    }

    // 일정 단건 조회
    @GetMapping("/{id}")
    @JsonView(View.Get.class)
    public ResponseEntity<ScheduleResponseDto> getSchedule(@PathVariable Long id) {
        ScheduleResponseDto responseDto = scheduleService.getSchedule(id);
        return ResponseEntity.ok(responseDto);
    }

    // 일정 수정
    @PatchMapping("/{id}")
    @JsonView(View.Update.class)
    public ResponseEntity<ScheduleResponseDto> updateSchedule(
            @PathVariable Long id,
            @Valid @RequestBody ScheduleRequestDto requestDto
    ) {
        ScheduleResponseDto responseDto = scheduleService.updateSchedule(id, requestDto);
        return ResponseEntity.ok(responseDto);
    }

    // 일정 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSchedule(@PathVariable Long id) {
        scheduleService.deleteSchedule(id);
        return ResponseEntity.noContent().build();
    }
}
