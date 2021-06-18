package com.tweet.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tweet.entity.User;

public interface UserTweetRepo  extends JpaRepository<User, String>{

}
