package com.binary.socialmediaapp.models;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Post {
	
	private Integer id;
	@NotNull(message = "Title is required")
	private String title;
	@NotNull(message = "Description is required")
	private String description;
	@NotNull(message = "Title is required")
	@Size(min = 10, message = "Body must be 10 charaters")
	@Size(max = 100, message = "Body canont exceed 100 characters")
	private String body;
	private String postStatus;
	private LocalDateTime createdOn;
	private LocalDate updatedOn;
	private List<Comment> comments;

}
