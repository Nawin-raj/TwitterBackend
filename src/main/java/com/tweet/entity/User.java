package com.tweet.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "users")
public class User {

	@Id
	String loginid;

	@OneToMany(cascade = CascadeType.ALL)
	@JoinColumn(name = "loginid", nullable = false, referencedColumnName = "loginid")
	List<Tweet> tweets = new ArrayList<>();

	public String getName() {
		return loginid;
	}

	public void setName(String loginid) {
		this.loginid = loginid;
	}

	public List<Tweet> getList() {
		return tweets;
	}

	public void setList(ArrayList<Tweet> tweets) {
		this.tweets = tweets;
	}

	public User(String loginid) {

		this.loginid = loginid;

	}

	public User() {
		super();
	}

	public User(String loginid, List<Tweet> tweets) {
		super();
		this.loginid = loginid;
		this.tweets = tweets;
	}

	@Override
	public String toString() {
		return "User [loginid=" + loginid + ", list=" + tweets + "]";
	}

}
