package com.alpha.orderingservice.service.impl;

import com.alpha.orderingservice.entity.User;
import com.alpha.orderingservice.payload.UserPayload;
import com.alpha.orderingservice.repository.UserRepository;
import com.alpha.orderingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private UserRepository userRepository;

    @Override
    public User createUser(UserPayload userPayload) {
        String hashedPassword = passwordEncoder.encode(userPayload.getPassword());

        User user = new User();
        user.setUserName(userPayload.getUserName());
        user.setPassword(hashedPassword);
        return userRepository.save(user);
    }

    @Override
    public User getUserByUserName( String userName) {
       return userRepository.findByUserName(userName).orElseThrow(()-> new RuntimeException("User not found"));

    }
}
