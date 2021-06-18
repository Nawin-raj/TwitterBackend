package com.tweet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class UserLikes {
	@Id
	String loginid;
	String post_id;

	public UserLikes() {
		super();
	}

	public UserLikes(String loginid, String post_id) {
		super();
		this.loginid = loginid;
		this.post_id = post_id;
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPost_id() {
		return post_id;
	}

	public void setPost_id(String post_id) {
		this.post_id = post_id;
	}

	@Override
	public String toString() {
		return "UserLikes [loginid=" + loginid + ", post_id=" + post_id + "]";
	}

}
