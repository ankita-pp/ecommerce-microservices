package com.example.demo.service;

import com.example.demo.exception.UserNotAuthenticatedException;
import com.example.demo.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final UserRepository userRepository;

    public void isAuthenticated(boolean authenticated, String userId) {
        if (authenticated && userRepository.findUserById(userId) != null) {
            log.info("User {} Authenticated", userId);
        } else
            throw new UserNotAuthenticatedException(userId);
    }
}
