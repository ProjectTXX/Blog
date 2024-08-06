package com.group.blogapi.domain.vo;

import cn.hutool.core.date.DateTime;
import com.group.blogapi.domain.Article;
import com.group.blogapi.domain.Tag;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class ArticleVo {
    private String articleTitle;
    private String introduction;
    private Date articleCreateTime;
    private String link;
    private List<Tag> tag;

    public ArticleVo(Article article) {
        this.articleTitle = article.getArticleTitle();
        this.introduction = article.getArticleIntroduction();
        this.articleCreateTime = article.getArticleCreateTime();
        this.link = article.getLink();
        this.tag = article.getTagList();
    }
}
