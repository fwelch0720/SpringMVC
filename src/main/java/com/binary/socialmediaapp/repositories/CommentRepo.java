package com.binary.socialmediaapp.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Repository;

import com.binary.socialmediaapp.models.Comment;

@Repository
public class CommentRepo {

	private final List<Comment> commentList = new ArrayList<>();
	private Integer idCount=100;
	
	public CommentRepo() {
		Comment comment1 = new Comment();
		comment1.setCommentMessage("EWWWWWW");
		comment1.setAuthorName("ME Mario");
		comment1.setId(idCount);
		this.addComment(1, comment1);
	
	}
	
	public void addComment(int postId, Comment comment) {
		comment.setPostId(postId);
		commentList.add(comment);
		idCount++;
	}
	
	public List<Comment>getCommentsByPostId(int postId) {
		return  commentList.stream()
				.filter(post -> post.getId() == postId)
				.collect(Collectors.toList());
				
		
		
	}

}
