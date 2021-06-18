package com.tweet.pojo;

public class Login {
	String loginid;
	String password;

	public Login(String loginid, String password) {
		super();
		this.loginid = loginid;
		this.password = password;
	}

	public Login() {
		super();
	}

	public String getLoginid() {
		return loginid;
	}

	public void setLoginid(String loginid) {
		this.loginid = loginid;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "Login [loginid=" + loginid + ", password=" + password + "]";
	}

}
