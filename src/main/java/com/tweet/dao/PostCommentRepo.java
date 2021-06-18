package com.tweet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweet.entity.PostComment;

public interface PostCommentRepo extends JpaRepository<PostComment, Integer>{

}
