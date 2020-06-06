package com.example.demo.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    @NotNull(message = "User must have first name!")
    private String firstName;
    private String lastName;
    @Email(message = "Please enter valid email!")
    private String email;
    @Pattern(message = "Please enter valid contact number!", regexp = "(^$|[0-9]{10})")
    private String contactNo;
    @Valid
    private Address address;
    private UserStatus status;
}
