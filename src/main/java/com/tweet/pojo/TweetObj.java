package com.tweet.pojo;

public class TweetObj {

	String tweetid;
	String message;
	String time;
	String loginid;

	public TweetObj(String tweetid, String message, String time, String loginid) {
		super();

		this.tweetid = tweetid;
		this.message = message;
		this.time = time;
		this.loginid = loginid;
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

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getTweetid() {
		return tweetid;
	}

	public void setTweetid(String tweetid) {
		this.tweetid = tweetid;
	}

	@Override
	public String toString() {
		return "TweetObj [message=" + message + ", time=" + time + ", tweetid=" + tweetid + ", loginid=" + loginid
				+ "]";
	}

}
