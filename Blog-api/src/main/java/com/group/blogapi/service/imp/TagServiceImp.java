package com.group.blogapi.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.group.blogapi.domain.Tag;
import com.group.blogapi.mapper.TagMapper;
import com.group.blogapi.service.TagService;
import org.springframework.stereotype.Service;


@Service
public class TagServiceImp extends ServiceImpl<TagMapper, Tag> implements TagService {



}
