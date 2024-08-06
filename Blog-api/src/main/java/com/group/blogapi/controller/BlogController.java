package com.group.blogapi.controller;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.group.blogapi.domain.Blog;
import com.group.blogapi.domain.vo.BlogIntroductionVo;
import com.group.blogapi.service.BlogService;
import com.group.blogapi.util.Rsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/blog")
public class BlogController {

    @Autowired
    private BlogService blogService;

    @GetMapping("/introduction")
    public Rsg showTheIntroductionAtTheHome(){

        Blog blog = blogService.getByUserId(1L);
        BlogIntroductionVo blogIntroductionVo = new BlogIntroductionVo(blog);
        JSONObject jsonObject = (JSONObject) JSON.toJSON(blogIntroductionVo);
        return Rsg.Ok(jsonObject);
    }
}
