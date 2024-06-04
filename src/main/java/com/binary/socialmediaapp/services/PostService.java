package com.binary.socialmediaapp.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.binary.socialmediaapp.models.Comment;
import com.binary.socialmediaapp.models.Post;
import com.binary.socialmediaapp.repositories.PostRepo;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class PostService {

	private final PostRepo repo;
	private final CommentService commentService;
	
	public void addPost(Post post) {
		repo.addPost(post);
	}
	
	public List<Post> findAllPosts(){
		List<Post> posts = repo.getAllPost();
		posts.stream().map(post ->{
			post.setComments(commentService.getAllCommentsbyPostId(post.getId()));
		return post;
		
		}).collect(Collectors.toList());
		return repo.getAllPost();
	}
	
	public Optional<Post> findById(int id){

	     return repo.getPostbyId(id);
	 }
	
	 public void updatePost(Post updatedPost){
	     repo.update(updatedPost);
	 }
	 
	 
	 public void addComment(Comment comment) {
			repo.addComment(comment);
		}
	 
	 public void deletePostById(Integer id){
	       repo.removePostbyId(id);
	 }

}
//did we need the service 