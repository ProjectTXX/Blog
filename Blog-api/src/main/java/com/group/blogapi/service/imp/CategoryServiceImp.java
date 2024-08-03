package com.group.blogapi.service.imp;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import com.group.blogapi.domain.Category;
import com.group.blogapi.mapper.CategoryMapper;
import com.group.blogapi.service.CategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImp extends ServiceImpl<CategoryMapper, Category> implements CategoryService {
}