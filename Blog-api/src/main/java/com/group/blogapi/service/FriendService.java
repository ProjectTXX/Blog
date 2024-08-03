package com.group.blogapi.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.group.blogapi.domain.Friend;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FriendService extends IService<Friend> {
}
