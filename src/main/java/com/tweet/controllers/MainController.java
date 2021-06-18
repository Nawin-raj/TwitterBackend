package com.tweet.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.tweet.entity.Likes;
import com.tweet.entity.PostComment;
import com.tweet.entity.Tweet;
import com.tweet.exception.APIRequestException;
import com.tweet.pojo.Login;
import com.tweet.pojo.TweetDataMapper;
import com.tweet.pojo.TweetUpdate;
import com.tweet.pojo.UserComment;
import com.tweet.pojo.UserDetails;
import com.tweet.services.LoginRegistrationService;
import com.tweet.services.TweetService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1.0/tweets")

public class MainController {
	@Autowired
	LoginRegistrationService logRegService;
	@Autowired
	TweetService tweetService;

	@RequestMapping(value = "/dummy")
	public String dummy() {
		throw new APIRequestException("Failed to login");
	}

	@PostMapping("/login")
	public String login(@RequestBody Login login) {
		return logRegService.userLogin(login);

	}

	@PostMapping("/register")
	public void register(@RequestBody UserDetails user) {
		logRegService.userRegister(user);

	}

	@GetMapping("/{username}/{password}/forgot")
	public void forgotPassword(@PathVariable("username") String username, @PathVariable("password") String password) {
		logRegService.forgotPassword(username, password);
	}

	@PostMapping("/usernamecheck")
	public String checkUserNameAvailability(@RequestBody String str) {
		return logRegService.usernamecheck(str);

	}

	@GetMapping("/users/all")
	public List<String> getAllUsers() {
		return logRegService.getAllUsers();
	}

	@PostMapping("/{username}/add")
	public List<TweetDataMapper> addTweet(@PathVariable("username") String username, @RequestBody Tweet tweet) {
		List<TweetDataMapper> tweets = tweetService.addTweet(username, tweet);
		return tweets;
	}

	@GetMapping("/all")
	public List<TweetDataMapper> getAllTweets() {
		List<TweetDataMapper> tweets = tweetService.getAllTweeets();
		return tweets;

	}

	@GetMapping("/{username}")
	public List<TweetDataMapper> getTweetsByUsername(@PathVariable("username") String username) {
		List<TweetDataMapper> user_tweets = tweetService.getTweetsByUsername(username);
		return user_tweets;
	}

	@DeleteMapping("/{username}/delete/{id}")
	public List<TweetDataMapper> deleteTweet(@PathVariable("username") String username, @PathVariable("id") String id) {
		return tweetService.deletePost(username, id);

	}

	@PutMapping("/{username}/update/{id}")
	public void updateTweet(@PathVariable("username") String username, @PathVariable("id") String id,
			@RequestBody TweetUpdate tweet) {
		tweetService.updatePost(id, tweet.getMessage());

	}

	@RequestMapping("/addcomment")
	public List<PostComment> addComment(@RequestBody UserComment comment) {
		return tweetService.addComment(comment);
	}

	@GetMapping("/getcomments")
	public List<PostComment> getComments() {
		return tweetService.getAllComments();
	}

	@GetMapping("/{loginid}/info")
	public UserDetails getUserProfile(@PathVariable("loginid") String loginid) {
		return logRegService.getUserInfo(loginid);

	}

	@PostMapping("/{username}/like/{post_id}")
	public void likeTweet(@PathVariable("username") String username, @PathVariable("post_id") int post_id) {
		tweetService.likeTweet(username, post_id);

	}

	@PostMapping("/likes")
	public List<Likes> getAllLikes() {
		return tweetService.getAllLikes();
	}

	@GetMapping("/{username}/likes")
	public int[] getPostsLikedByUser(@PathVariable("username") String username) {
		return tweetService.getPostsLikedByUser(username);

	}

	@GetMapping("/{username}/likedposts")
	public List<TweetDataMapper> userLikedTweets(@PathVariable("username") String username) {
		return tweetService.getUserLikesPosts(username);
	}

}
