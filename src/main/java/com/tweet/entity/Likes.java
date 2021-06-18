package com.tweet.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Likes {
	@Id
	int post_id;
	int likecount;

	public Likes() {

	}

	public Likes(int post_id, int likecount) {
		super();
		this.post_id = post_id;
		this.likecount = likecount;
	}

	public int getPost_id() {
		return post_id;
	}

	public void setPost_id(int post_id) {
		this.post_id = post_id;
	}

	public int getLikecount() {
		return likecount;
	}

	public void setLikecount(int likecount) {
		this.likecount = likecount;
	}

	@Override
	public String toString() {
		return "Likes [post_id=" + post_id + ", likecount=" + likecount + "]";
	}

}
