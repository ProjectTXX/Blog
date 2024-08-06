package com.group.blogapi.mapper;

import com.group.blogapi.domain.Article;
import com.group.blogapi.util.Rsg;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {


    Article getById(int i);

    int getNumsOfArticle();

    int getNumsOfRecentlyAddedArticle();
}
