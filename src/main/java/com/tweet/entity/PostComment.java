package com.tweet.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
public class PostComment {

	@Id
	int postid;

	@OneToMany(cascade = CascadeType.ALL )
	@JoinColumn(name = "postid", nullable = false, referencedColumnName = "postid")
	List<Comments> comments = new ArrayList<>();

	public PostComment() {

	}

	public PostComment(int postid) {
		super();
		this.postid = postid;
	}

	public PostComment(int postid, List<Comments> comments) {
		super();
		this.postid = postid;
		this.comments = comments;
	}

	public int getPostid() {
		return postid;
	}

	public void setPostid(int postid) {
		this.postid = postid;
	}

	public List<Comments> getComments() {
		return comments;
	}

	public void setComments(List<Comments> comments) {
		this.comments = comments;
	}

	@Override
	public String toString() {
		return "PostComment [postid=" + postid + ", comments=" + comments + "]";
	}

}
