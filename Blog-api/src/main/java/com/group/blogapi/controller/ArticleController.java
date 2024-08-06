package com.group.blogapi.controller;

import com.alibaba.fastjson.JSONObject;
import com.group.blogapi.domain.Article;
import com.group.blogapi.domain.vo.ArticleVo;
import com.group.blogapi.domain.vo.InformationVo;
import com.group.blogapi.service.ArticleService;
import com.group.blogapi.service.InformationService;
import com.group.blogapi.util.Rsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/article")
public class ArticleController {


    @Autowired
    private ArticleService articleService;

    @Autowired
    private InformationService informationService;
    @GetMapping()
    public Rsg getARandomArticle(){

        Article article = articleService.getById(1);
        ArticleVo articleVo = new ArticleVo(article);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(articleVo);
        return Rsg.Ok(jsonObject);
    }
    @GetMapping("/{articleId}")
    public Rsg getArticleById(@PathVariable int articleIdid){

        Article article = articleService.getById(articleIdid);
        ArticleVo articleVo = new ArticleVo(article);
        JSONObject jsonObject = (JSONObject) JSONObject.toJSON(articleVo);
        return Rsg.Ok(jsonObject);
    }

}
