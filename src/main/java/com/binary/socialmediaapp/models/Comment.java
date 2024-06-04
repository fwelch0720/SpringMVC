package com.binary.socialmediaapp.models;

import java.time.LocalDate;
import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Comment {
	
	private Integer id;
	private String authorName;
	private String commentMessage;
	private Integer postId;
	private LocalDateTime createdOn;
	private LocalDate updatedOn;

}
