package com.example.walkingclub.repository;

import com.example.walkingclub.entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CommentRepository extends JpaRepository<Comment, Long> {

    // 댓글 조회
    List<Comment> findByScheduleId(Long scheduleId);
}
