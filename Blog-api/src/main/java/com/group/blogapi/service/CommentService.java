package com.group.blogapi.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.group.blogapi.domain.Comment;

import java.util.List;

public interface CommentService extends IService<Comment> {

    int getTotalNumsOfComments();
}