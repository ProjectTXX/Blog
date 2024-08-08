package com.group.blogapi.domain;


import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("blog_tag")
public class BlogTag {

	private Long blogId;

	private Long tagId;


}
