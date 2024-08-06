package com.group.blogapi.service.imp;

import com.group.blogapi.domain.Article;
import com.group.blogapi.mapper.ArticleMapper;
import com.group.blogapi.service.ArticleService;
import com.group.blogapi.util.Rsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArticleServiceImpl implements ArticleService {

    @Autowired
    private ArticleMapper articleMapper;

    @Override
    public int getNumsOfRecentlyAddedArticle() {
        int nums = articleMapper.getNumsOfRecentlyAddedArticle();
        return nums;
    }

    public Article getById(int i) {
        return articleMapper.getById(i);
    }
}
