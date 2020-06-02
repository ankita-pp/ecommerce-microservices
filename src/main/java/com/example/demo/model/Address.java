package com.example.demo.model;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
	private String address1;
	private String address2;
	private String city;
	private String state;
	private String country;
	private String pinCode;
	private List<String> userContact;
}
