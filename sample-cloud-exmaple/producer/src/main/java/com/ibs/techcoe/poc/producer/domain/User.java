package com.ibs.techcoe.poc.producer.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.annotations.ApiModelProperty;

@Document
public class User {

	@Id
	private Long  id;

	private String username;

	public Long  getId() {
		return id;
	}

	public void setId(Long  id) {
		this.id = id;
	}
	@JsonProperty(required = true)
    @ApiModelProperty(notes = "The name of the user", required = true)
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}
}