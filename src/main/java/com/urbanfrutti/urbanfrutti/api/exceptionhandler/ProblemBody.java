package com.urbanfrutti.urbanfrutti.api.exceptionhandler;

import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

@JsonInclude(Include.NON_NULL)
public class ProblemBody {
	private Integer status;
	private String title;
	private String message;
	private LocalDateTime timestamp;
	
	public ProblemBody() {
		this.timestamp = LocalDateTime.now();
	}
	
	public ProblemBody(Integer status, String title, String message) {
		this.status = status;
		this.title = title;
		this.message = message;
		this.timestamp = LocalDateTime.now();
	}

	public Integer getStatus() {
		return status;
	}

	public String getTitle() {
		return title;
	}

	public String getMessage() {
		return message;
	}

	public LocalDateTime getTimestamp() {
		return timestamp;
	}
	
}
