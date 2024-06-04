package com.binary.socialmediaapp.controllers;

import java.util.Optional;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.binary.socialmediaapp.models.Comment;
import com.binary.socialmediaapp.models.Post;
import com.binary.socialmediaapp.services.PostService;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/posts")
@RequiredArgsConstructor
public class PostController {
	
	private final PostService postService;
	
	@GetMapping({"" ,"/list","/postList"})
	public String postPage(Model m) {
		

		m.addAttribute("timeline", postService.findAllPosts());
		return "posts/postIndex";
	}
	
	@GetMapping("/create")
	public String createPostPage(Model m) {
		m.addAttribute("newPost", new Post());
		
		return "posts/createPost";
	}
	
	@PostMapping("/create")
	public String createPost(@ModelAttribute @Valid Post newPost, Errors result) {
		if(result.hasErrors()) {
			return "redirect:/posts/create";
		}
		postService.addPost(newPost);
		return "redirect:/posts/list";
	}
	

	@GetMapping("/update/{id}")
    public String updatePostPage(@PathVariable("id") Integer id,  Model model){

        Optional<Post> optionalPost = postService.findById(id);
        Post updatedpost=null;
        if(optionalPost.isPresent()) {
            updatedpost = optionalPost.get();
        }else {
            return "redirect:/posts/list";
        }

        model.addAttribute("postNeedToUpdate", updatedpost);
        System.out.println(updatedpost);
        return "posts/updatePost";
    }
	
	@PostMapping("/update/{id}")
	public String updatePost(@PathVariable("id")Integer id, @ModelAttribute("postNeedToUpdate")@Valid Post updatedPost, Errors errors) {
		if(errors.hasErrors()){
			System.out.println(errors.getAllErrors());
			return "posts/updatePost";
		}
		System.out.println(updatedPost);
        postService.updatePost(updatedPost);

        return "redirect:/posts/list";
		
		
	}
	
	/*@PostMapping("/create")
	public String createUpdate(@ModelAttribute @Valid Comment newPost, BindingResult result) {
		if(result.hasErrors()) {
			return "redirect:/posts/create";
		}
		postService.addComment(newPost);
		return "redirect:/posts/list";
	}*/
	

	
	
	   @GetMapping("/delete/{id}")
	    public String deletePostPage(@PathVariable("id") Integer id, Model model){

	        return "posts/deletePostPage";
	    }

	    @PostMapping("/delete/{id}")
	    public String deletePost(@PathVariable("id") Integer id){

	       postService.deletePostById(id);

	       return "redirect:/posts/list";
	    }
	
	

}
