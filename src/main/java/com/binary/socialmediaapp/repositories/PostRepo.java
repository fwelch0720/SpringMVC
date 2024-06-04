package com.binary.socialmediaapp.repositories;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.binary.socialmediaapp.models.Comment;
import com.binary.socialmediaapp.models.Post;

@Repository
public class PostRepo {
	
	private final List<Post> postList = new ArrayList<>();
	private final List<Comment> commentList = new ArrayList<>();
	   private int idCount=1;
	
	public PostRepo() {
		Post post1 = new Post();
		post1.setTitle("Hello SpringMVC");
		post1.setDescription("Starting SpringMVC");
		post1.setBody("SpringBoot is Fun");
		post1.setId(54);
		
		Post post2 = new Post();
		post2.setTitle("Im ready for a job");
		post2.setDescription("I want to make 150k/y");
		post2.setBody("I WILL HAVE A JOB");
		post2.setId(10);
		
		Post post3 = new Post();
		post3.setTitle("Sport Playoffs");
		post3.setDescription("NBA Playoffs");
		post3.setBody("Boston will win");
		post3.setId(11);
		
		postList.add(post1);
		postList.add(post2);
		postList.add(post3);

	}
	
	public void addPost(Post post){
	       post.setId(idCount);
	       postList.add(post);
	       idCount++;
	   }	
	public List<Post> getAllPost(){
		return postList;
	}
	
	 public Optional<Post> getPostbyId(int id){
	      return  postList.stream().filter((post -> post.getId() == id)).findFirst();
	   }
	
	 public void update(Post updatedPost) {

	       for(int i =0; i <postList.size(); i++){
	           if(postList.get(i).getId().equals(updatedPost.getId())){
	               postList.set(i, updatedPost);
	               break;
	           }
	       }
	       	}
	 
	 
	 
	 public void addComment(Comment post){
	       post.setId(idCount);
	       commentList.add(post);
	       idCount++;
	 }
	 
	  public void removePostbyId(Integer id){

	        for(int i =0; i <postList.size(); i++){
	            if(postList.get(i).getId() == id){
	                  postList.remove(i);
	                  break;
	            }
	        }
	    }
	
}
