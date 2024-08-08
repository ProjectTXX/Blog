package com.group.blogapi.service;

import com.group.blogapi.domain.User;

public interface UserService {
    void registerUser(User user);



    User getUserByUsernameAndPassword(String username, String password);
}
