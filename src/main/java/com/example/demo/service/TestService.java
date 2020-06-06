package com.example.demo.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
public class TestService {
	private final RestTemplate restTemplate;

	public String getData() {
		return restTemplate.getForObject("http://localhost:8080/test/hello", String.class) +
				" " + restTemplate.getForObject("http://localhost:8080/test/world", String.class);
	}
}
