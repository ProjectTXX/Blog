package com.group.blogapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.group.blogapi.domain.Comment;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface CommentMapper extends BaseMapper<Comment> {


    int getTotalNumsOfComments();
}