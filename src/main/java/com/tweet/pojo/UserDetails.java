package com.tweet.pojo;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity()
public class UserDetails {
	@Id
	String loginid;
	String firstname;
	String lastname;
	String password;
	String phonenum;
	String email;

	public UserDetails(String loginid, String firstname, String lastname, String password, String phonenum,
			String email) {
		super();
		this.loginid = loginid;
		this.firstname = firstname;
		this.lastname = lastname;
		this.password = password;
		this.phonenum = phonenum;
		this.email = email;
	}

	public UserDetails() {
		super();
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getFirstname() {
		return firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPhonenum() {
		return phonenum;
	}

	public void setPhonenum(String phonenum) {
		this.phonenum = phonenum;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return "UserDetails [loginid=" + loginid + ", firstname=" + firstname + ", lastname=" + lastname + ", password="
				+ password + ", phonenum=" + phonenum + ", email=" + email + "]";
	}

}
