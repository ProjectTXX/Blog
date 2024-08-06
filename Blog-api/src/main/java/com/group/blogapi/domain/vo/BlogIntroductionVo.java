package com.group.blogapi.domain.vo;

import com.group.blogapi.domain.Blog;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BlogIntroductionVo {

    private String title;
    private String firstPicture;
    private String content;
    private String description;

    public BlogIntroductionVo(Blog blog) {
        this.content = blog.getContent();
        this.description = blog.getDescription();
        this.firstPicture = blog.getFirstPicture();
        this.title = blog.getTitle();
    }
}
