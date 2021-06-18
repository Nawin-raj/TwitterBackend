package com.tweet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tweet.entity.UserLikes;

public interface UserLikeRepo extends JpaRepository<UserLikes, String> {

	
	@Modifying
	@Query(value = "UPDATE user_likes SET post_id=:post_ids WHERE loginid=:loginid ", nativeQuery = true)
	void addpostid( @Param("loginid") String loginid,@Param("post_ids") String post_ids);

	

}
