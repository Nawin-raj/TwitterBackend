package com.tweet.pojo;

public class UserComment {
	int tweetid;
	String comment;
	String loginid;
	public UserComment(int tweetid, String comment, String loginid) {
		super();
		this.tweetid = tweetid;
		this.comment = comment;
		this.loginid = loginid;
	}
	public UserComment() {
		super();
	}
	public int getTweetid() {
		return tweetid;
	}
	public void setTweetid(int tweetid) {
		this.tweetid = tweetid;
	}
	public String getComment() {
		return comment;
	}
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getLoginid() {
		return loginid;
	}
	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}
	@Override
	public String toString() {
		return "UserComment [tweetid=" + tweetid + ", comment=" + comment + ", loginid=" + loginid + "]";
	}

}
