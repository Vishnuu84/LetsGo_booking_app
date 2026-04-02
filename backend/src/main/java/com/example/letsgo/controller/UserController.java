package com.example.letsgo.service;

import com.example.letsgo.model.User;
import com.example.letsgo.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Requirement 5: Logging for user actions
    private static final Logger logger = LoggerFactory.getLogger(UserService.class);

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    public User registerUser(User user) {
        logger.info("Attempting to register user: {}", user.getUsername()); // Log API request [cite: 55]

        // Requirement 3: Security - Encrypt the password before saving
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setRole("USER");

        User savedUser = userRepository.save(user);
        logger.info("User {} successfully registered.", savedUser.getUsername()); // Log success

        return savedUser;
    }
}