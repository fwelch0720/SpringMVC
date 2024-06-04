package com.binary.socialmediaapp.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.binary.socialmediaapp.models.Comment;
import com.binary.socialmediaapp.repositories.CommentRepo;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CommentService {
	
	private final CommentRepo commentRepo;
	
	public List<Comment> getAllCommentsbyPostId(int postId){
		return commentRepo.getCommentsByPostId(postId);
	}

}
