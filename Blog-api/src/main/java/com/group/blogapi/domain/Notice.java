package com.group.blogapi.domain;

import lombok.Data;

import java.util.Date;

@Data
public class Notice {
    private Integer noticeId;

    private String title;

    private String content;

    private Date createTime;

    private Date updateTime;
}
