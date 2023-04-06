package com.masai.exception;

import java.time.LocalDateTime;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingError {

	private LocalDateTime timestamp;
	private String message;
	private String description;
	private String path;

	

}
