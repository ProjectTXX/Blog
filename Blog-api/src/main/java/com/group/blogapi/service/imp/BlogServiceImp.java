package com.group.blogapi.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.group.blogapi.domain.Blog;
import com.group.blogapi.mapper.BlogMapper;
import com.group.blogapi.service.BlogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Slf4j
@Service
public class BlogServiceImp extends ServiceImpl<BlogMapper, Blog> implements BlogService {

    @Autowired
    private BlogMapper blogMapper;

    @Override
    public int getNumsOfRecentlyViewers() {
        return blogMapper.getNumsOfRecentlyViewers();
    }

    public Blog getByUserId(Long id) {
        return blogMapper.getById(id);

    }
}
