package com.tweet.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.tweet.pojo.Login;
import com.tweet.pojo.UserDetails;

@Repository
public interface UserRepo extends JpaRepository<UserDetails, String> {
	@Query(value = "select u.loginid from user_details u", nativeQuery = true)
	public List<String> getallusernames();

	@Query(value = "select user_details.password from user_details WHERE loginid=:loginid", nativeQuery = true)
	public String getpasswordbyloginid(@Param("loginid") String loginid);

	@Modifying
	@Query(value = "UPDATE user_details SET password=:password WHERE loginid=:loginid ", nativeQuery = true)
	public void updatepassword(@Param("loginid") String loginid, @Param("password") String password);

}
