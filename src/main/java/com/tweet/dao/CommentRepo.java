package com.tweet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweet.entity.Comments;

public interface CommentRepo extends JpaRepository<Comments, String>{

}
