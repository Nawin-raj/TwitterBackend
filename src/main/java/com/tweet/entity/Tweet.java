package com.tweet.entity;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tweets")
public class Tweet {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int tweetid;
	String message;
	String time;

	public Tweet() {
		super();
	}

	public Tweet(String message, String time) {
		super();
		this.message = message;
		this.time = time;

	}

	public int getTweetid() {
		return tweetid;
	}

	public void setTweetid(int tweetid) {
		this.tweetid = tweetid;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTime() {
		return time;
	}

	public void setTime(String time) {
		this.time = time;
	}

	@Override
	public String toString() {
		return "Tweet [tweetid=" + tweetid + ", message=" + message + ", time=" + time + "]";
	}

}
