package com.group.blogapi.service.imp;


import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.group.blogapi.domain.BlogTag;
import com.group.blogapi.mapper.BlogTagMapper;
import com.group.blogapi.service.BlogTagService;
import org.springframework.stereotype.Service;


@Service
public class BlogTagServiceImp extends ServiceImpl<BlogTagMapper, BlogTag> implements BlogTagService {


}