package com.example.walkingclub.repository;

import com.example.walkingclub.entity.Comment;
import com.example.walkingclub.entity.Reply;
import com.example.walkingclub.entity.Schedule;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    @Modifying(clearAutomatically = true)
    @Query("DELETE FROM Reply reply WHERE reply.schedule = :schedule")
    void deleteBySchedule(@Param("schedule") Schedule schedule);

    List<Reply> findByComment(Comment comment);
}
