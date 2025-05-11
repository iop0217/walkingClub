package com.example.walkingclub.repository;

import com.example.walkingclub.dto.ScheduleListResponseDto;
import com.example.walkingclub.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ScheduleRepository extends JpaRepository<Schedule, Long> {

    @Query("""
            SELECT new com.example.walkingclub.dto.ScheduleListResponseDto(
            schedule.writerId,
            schedule.id,
            schedule.title,
            count(c),
            schedule.createdAt,
            schedule.updatedAt
            )
            FROM Schedule schedule
            LEFT JOIN Comment c ON c.schedule = schedule
            GROUP BY schedule.id
            """)
    List<ScheduleListResponseDto> findCommentCount();
}
