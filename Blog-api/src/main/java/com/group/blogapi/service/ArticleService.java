package com.group.blogapi.service;

import com.group.blogapi.domain.Article;
import com.group.blogapi.util.Rsg;

public interface ArticleService {
    Article getById(int i);

    int getNumsOfRecentlyAddedArticle();
}
