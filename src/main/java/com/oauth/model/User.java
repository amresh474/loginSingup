package com.oauth.model;

import java.io.Serializable;
import java.sql.Date;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Data
@Document("user")
public class User implements Serializable {
	private static final long serialVersionUID = -5628664968903021377L;

	@Id
	private String mobile;
	private String firstName;
	private String lastName;
	private String user;

	private String email;
	private String password;

	private Date dob;
	private String createdbycat;
	private String updatedbycat;

}
