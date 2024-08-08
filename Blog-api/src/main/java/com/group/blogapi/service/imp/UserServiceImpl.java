package com.group.blogapi.service.imp;

import com.group.blogapi.domain.User;
import com.group.blogapi.mapper.UserMapper;
import com.group.blogapi.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public void registerUser(User user) {
        userMapper.registerUser(user);
    }
    @Override
    public User getUserByUsernameAndPassword(String username, String password) {
        return userMapper.getUserByUsernameAndPassword(username, password);
    }
}
