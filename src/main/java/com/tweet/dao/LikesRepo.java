package com.tweet.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tweet.entity.Likes;

public interface LikesRepo extends JpaRepository<Likes, Integer> {

	@Modifying
	@Query(value = "UPDATE likes SET likecount=:likecount WHERE post_id=:post_id ", nativeQuery = true)
	void updatelikecount(@Param("post_id") int post_id, @Param("likecount") int likecount);

}
