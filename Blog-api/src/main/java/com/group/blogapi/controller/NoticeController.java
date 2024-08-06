package com.group.blogapi.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.group.blogapi.domain.Notice;
import com.group.blogapi.service.NoticeService;
import com.group.blogapi.util.Rsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/notice")
public class NoticeController {


    @Autowired
    private NoticeService noticeService;
    @GetMapping()
    public Rsg showTheNewestNotice(){
        Notice notice = noticeService.getTheNewestNotice();
        JSONObject jsonObject = (JSONObject) JSON.toJSON(notice);
        return Rsg.Ok(jsonObject);
    }
}
