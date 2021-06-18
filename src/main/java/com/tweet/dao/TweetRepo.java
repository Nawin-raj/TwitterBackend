package com.tweet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.tweet.entity.Tweet;
import com.tweet.pojo.TweetDataMapper;

public interface TweetRepo extends JpaRepository<Tweet, Integer> {

	@Query(value = "select tweets.message , tweets.time, tweets.tweetid,tweets.loginid  from tweets WHERE loginid=:loginid", nativeQuery = true)
	public List<TweetDataMapper> getTweetsByName(@Param("loginid") String loginid);

	@Query(value = "SELECT tweets.tweetid , tweets.message , tweets.time , tweets.loginid from tweets ",nativeQuery = true)
	public List<TweetDataMapper> getalltweets();

	@Modifying
	@Query(value = "DELETE FROM tweets WHERE tweetid=:tweetid ", nativeQuery = true)
	public void deletepost(@Param("tweetid") String tweetid);

	@Modifying
	@Query(value = "UPDATE tweets SET message=:msg WHERE  tweetid=:tweetid ", nativeQuery = true)
	public void updatepost(@Param("tweetid") String tweetid, @Param("msg") String msg);
	
	@Query(value = "SELECT tweets.tweetid , tweets.message , tweets.time , tweets.loginid from tweets where tweets.tweetid IN (:ids)",nativeQuery = true)
	public List<TweetDataMapper> getuserlikedtweets(@Param("ids") int[] ids);

}
