package com.tweet.services;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import com.tweet.dao.UserRepo;
import com.tweet.exception.APIRequestException;
import com.tweet.pojo.Login;
import com.tweet.pojo.UserDetails;

@Service
public class LoginRegistrationService {
	@Autowired
	UserRepo userrepo;

	public String userLogin(Login login) {

		System.out.println(login);
		List<String> loginlist = userrepo.getallusernames();
		System.out.println(loginlist);
		if (loginlist != null && loginlist.contains(login.getLoginid())) {
			String password_from_db = userrepo.getpasswordbyloginid(login.getLoginid());
			System.out.println(password_from_db);
			if (password_from_db.equals(login.getPassword()))
				return "Valid user";

			else
				throw new APIRequestException("Failed to login");

		}

		else {
			throw new APIRequestException("Failed to login");
		}
	}

	public void userRegister(UserDetails user) {
		userrepo.save(user);
	}

	@Transactional
	public void forgotPassword(String username, String password) {
		userrepo.updatepassword(username, password);
	}

	public String usernamecheck(String str) {
		String username = str.substring(0, str.length() - 1);
		List<String> loginlist = userrepo.getallusernames();
		if (loginlist.contains(username))
			return "Taken";
		else
			return "Not Taken";

	}

	public UserDetails getUserInfo(String loginid) {

		return userrepo.findById(loginid).get();
	}

	public List<String> getAllUsers() {
		List<String> allusers = userrepo.getallusernames();
		return allusers;
	}
}
