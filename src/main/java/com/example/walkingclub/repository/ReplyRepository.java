package com.example.walkingclub.repository;

import com.example.walkingclub.entity.Reply;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReplyRepository extends JpaRepository<Reply, Long> {

    // 대댓글 조회
    List<Reply> findByCommentId(Long commentId);
}
