package com.example.demo.service;

import com.example.demo.model.Address;
import com.example.demo.model.User;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.validation.Valid;

@Slf4j
@Service
@RequiredArgsConstructor
public class TestService {
    private final RestTemplate restTemplate;

    public String getData() {
        return restTemplate.getForObject("http://localhost:8080/test/hello", String.class) +
                " " + restTemplate.getForObject("http://localhost:8080/test/world", String.class);
    }

    public static void main(String[] args) {
        @Valid
        User user = User.builder()
                .firstName("Ankita")
                .lastName("pande")
                .address(Address.builder()
                        .address1("vardhman township")
                        .address2("hadapsar")
                        .city("pune")
                        .country("India")
                        .pinCode("xyz")
                        .build())
                .build();
        log.info("User details {}", user);


    }
}
