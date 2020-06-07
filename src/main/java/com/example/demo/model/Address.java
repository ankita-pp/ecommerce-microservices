package com.example.demo.model;

import com.example.demo.validator.NumericString;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

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
    @NumericString(message = "{address.pincode.validation.message}")
    //@Pattern(message = "Please enter valid pin code!", regexp = "(^$|[0-9]{6})")
    private String pinCode;
    private List<String> userContact;
}
