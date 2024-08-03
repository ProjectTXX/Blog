package com.group.blogapi.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.group.blogapi.domain.Friend;
import com.group.blogapi.mapper.FriendMapper;
import com.group.blogapi.service.FriendService;
import org.springframework.stereotype.Service;

@Service
public class FriendServiceImp extends ServiceImpl<FriendMapper, Friend> implements FriendService {
}
