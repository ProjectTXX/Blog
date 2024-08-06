package com.group.blogapi.controller;

import com.alibaba.fastjson.JSONObject;
import com.group.blogapi.domain.vo.InformationVo;
import com.group.blogapi.service.ArticleService;
import com.group.blogapi.service.BlogService;
import com.group.blogapi.service.CommentService;
import com.group.blogapi.service.InformationService;
import com.group.blogapi.util.Rsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/information")
public class InfomationController {

    @Autowired
    private InformationService informationService;

    @Autowired
    private BlogService blogService;

    @Autowired
    private ArticleService articleService;
    @Autowired
    private CommentService commentService;
    @GetMapping
    public Rsg getInformation(){
        InformationVo informationVo = informationService.getInformations();
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(informationVo);
        return Rsg.Ok(jsonObject);
    }
    @GetMapping("/total/articles")
    public Rsg getTotalNumsOfArticle(){
        InformationVo informationVo = informationService.getInformations();
        return Rsg.Ok(informationVo.getTotalNumsOfArticle());
    }

    @GetMapping("/recently/article")
    public Rsg getNumsOfRecentlyAddedArticle(){
        int nums = articleService.getNumsOfRecentlyAddedArticle();
        return Rsg.Ok("本月新增加文章" + nums + "篇");
    }

    @GetMapping("/total/viewers")
    public Rsg getTotalNumsOfViewers(){
        InformationVo informationVo = informationService.getInformations();
        int nums = informationVo.getTotalNumsOfViewers();
        return Rsg.Ok(informationVo.getTotalNumsOfViewers());
    }
    @GetMapping("/recently/viewers")
    public Rsg getNumsOfRecentlyViewers(){
        int nums = blogService.getNumsOfRecentlyViewers();
        return Rsg.Ok("本月新增加文章" + nums + "篇");
    }
    @GetMapping("/total/comment")
    public Rsg getTotalNumsOfComment(){

        int nums = commentService.getTotalNumsOfComments();
        return Rsg.Ok(nums);
    }
    @GetMapping("/total/link")
    public Rsg getTotalNumsOfFriendLink(){

        int nums = commentService.getTotalNumsOfComments();
        return Rsg.Ok(nums);
    }

}
