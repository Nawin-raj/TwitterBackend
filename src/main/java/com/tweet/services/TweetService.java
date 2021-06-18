package com.tweet.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tweet.dao.CommentRepo;
import com.tweet.dao.LikesRepo;
import com.tweet.dao.PostCommentRepo;
import com.tweet.dao.TweetRepo;
import com.tweet.dao.UserLikeRepo;
import com.tweet.dao.UserTweetRepo;
import com.tweet.entity.Comments;
import com.tweet.entity.Likes;
import com.tweet.entity.PostComment;
import com.tweet.entity.Tweet;
import com.tweet.entity.User;
import com.tweet.entity.UserLikes;
import com.tweet.pojo.TweetDataMapper;
import com.tweet.pojo.UserComment;

@Service
public class TweetService {
	@Autowired
	UserTweetRepo user1repo;
	@Autowired
	TweetRepo tweetrepo;
	@Autowired
	LikesRepo likesrepo;
	@Autowired
	UserLikeRepo userlikerepo;
	@Autowired
	PostCommentRepo postcommentRepo;
	@Autowired
	CommentRepo commentRepo;

	public List<TweetDataMapper> addTweet(String username, Tweet t) {
		Tweet tweet = new Tweet(t.getMessage(), t.getTime());
		ArrayList<Tweet> list = new ArrayList();
		list.add(tweet);
		User u = new User(username, list);
		user1repo.save(u);
		return tweetrepo.getalltweets();
	}

	public List<TweetDataMapper> getAllTweeets() {
		List<TweetDataMapper> tweets = tweetrepo.getalltweets();
		return tweets;

	}

	public List<TweetDataMapper> getTweetsByUsername(String username) {
		List<TweetDataMapper> user_tweets = tweetrepo.getTweetsByName(username);
		return user_tweets;
	}

	@Transactional
	public List<TweetDataMapper> deletePost(String username, String id) {
		System.out.println("In delete post id");
		tweetrepo.deletepost(id);
		List<TweetDataMapper> user_tweets = tweetrepo.getTweetsByName(username);

		return user_tweets;

	}

	@Transactional
	public void updatePost(String id, String updatedtweet) {
		tweetrepo.updatepost(id, updatedtweet);

	}

	public List<PostComment> addComment(UserComment comment) {
		ArrayList<Comments> list = new ArrayList();
		Comments c = new Comments(comment.getLoginid(), comment.getComment());
		list.add(c);
		PostComment p = new PostComment(comment.getTweetid(), list);
		postcommentRepo.save(p);
		System.out.println("In comment controller");
		List<PostComment> listcomments = postcommentRepo.findAll();
		System.out.println(listcomments);

		return listcomments;
	}

	public List<PostComment> getAllComments() {
		List<PostComment> listcomments = postcommentRepo.findAll();
		System.out.println(listcomments);
		return listcomments;
	}

	public List<TweetDataMapper> getUserLikesPosts(String username) {
		int[] list = getPostsLikedByUser(username);
		return tweetrepo.getuserlikedtweets(list);
	}

	@Transactional
	public void likeTweet(String username, int post_id) {
		Likes likes;
		UserLikes user_likes;
		System.out.println("in like method");
		System.out.println(username + " " + post_id);

		Optional<Likes> likelist = likesrepo.findById(post_id);
		System.out.println(likelist);

		if (!likelist.isPresent()) {
			System.out.println("in if");

			likes = new Likes(post_id, 1);
			likesrepo.save(likes);
		} else {
			Likes likerow = likesrepo.getOne(post_id);
			likesrepo.updatelikecount(post_id, likerow.getLikecount() + 1);

		}
		Optional<UserLikes> userlike = userlikerepo.findById(username);

		if (!userlike.isPresent()) {
			user_likes = new UserLikes(username, String.valueOf(post_id));
			userlikerepo.save(user_likes);
		} else {

			UserLikes row = userlikerepo.getOne(username);
			String post_ids = row.getPost_id() + "," + String.valueOf(post_id);

			userlikerepo.addpostid(username, post_ids);
		}

	}

	public List<Likes> getAllLikes() {
		List<Likes> likelist = likesrepo.findAll();
		return likelist;
	}

	public int[] getPostsLikedByUser(String username) {
		// String likes = userlikerepo.getOne(username).getPost_id();
		Optional<UserLikes> likes = userlikerepo.findById(username);

		if (likes.isPresent()) {
			System.out.println(likes);
			String arr[] = likes.get().getPost_id().split(",");
			int[] post_array = Arrays.asList(arr).stream().mapToInt(Integer::parseInt).toArray();

			return post_array;

		} else {
			

			return null;

		}

	}

}
