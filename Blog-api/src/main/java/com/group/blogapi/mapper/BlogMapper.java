package com.group.blogapi.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.group.blogapi.domain.Blog;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BlogMapper extends BaseMapper<Blog> {

    Blog getById(long id);

    int getNumsOfViewers();

    int getNumsOfRecentlyViewers();
}
