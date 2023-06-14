package com.alpha.orderingservice.service;

import com.alpha.orderingservice.entity.User;
import com.alpha.orderingservice.payload.UserPayload;

public interface UserService {
    User createUser(UserPayload userPayload);
    User getUserByUserName(String username);
}
