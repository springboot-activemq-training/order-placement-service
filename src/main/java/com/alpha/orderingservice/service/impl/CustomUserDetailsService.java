package com.alpha.orderingservice.service.impl;

import com.alpha.orderingservice.entity.SecurityUserDetails;
import com.alpha.orderingservice.entity.User;
import com.alpha.orderingservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class CustomUserDetailsService implements UserDetailsService {
    @Autowired
    private UserService userService;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userService.getUserByUserName(username);
       return new SecurityUserDetails(user.getUserName(),user.getPassword());
    }
}
