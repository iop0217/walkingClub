package com.example.walkingclub.repository;

import com.example.walkingclub.entity.Comment;
import com.example.walkingclub.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {
    List<Reply> findByComment(Comment comment);
}
