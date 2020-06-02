package com.example.demo.model;

import javax.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
	@Id
	private String id;
	private String firstName;
	private String lastName;
	private Address address;
	private UserStatus status;
}
