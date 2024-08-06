package com.group.blogapi.domain;

import cn.hutool.core.date.DateTime;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Article {
    private Integer articleId;

    private Integer articleUserId;

    private String articleTitle;

    private Integer articleViewCount;

    private Date articleCreateTime;

    private Date articleUpdateTime;

    private String articleContent;

    private String articleIntroduction;

    private String link;

    private List<Tag> tagList;


}
