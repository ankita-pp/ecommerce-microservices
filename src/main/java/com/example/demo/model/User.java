package com.example.demo.model;

import lombok.*;

import javax.persistence.Id;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

@Data
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    private String id;
    @NotNull(message = "{user.firstName.validation.message}")
    private String firstName;
    private String lastName;
    @Email(message = "{user.email.validation.message}")
    private String email;
    @Pattern(message = "{user.contactNo.validation.message}", regexp = "(^$|[0-9]{10})")
    private String contactNo;
    @Valid
    private Address address;
    private UserStatus status;
}
