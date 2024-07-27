package com.group.blogapi.controller;

import com.alibaba.fastjson.JSON;
import com.group.blogapi.domain.User;
import com.group.blogapi.domain.vo.UserVo;
import com.group.blogapi.util.JwtUtil;
import com.group.blogapi.util.Rsg;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserDetailsService userDetails;

    @PostMapping("/login")
    public Rsg login(@RequestBody User user){
        UserDetails userDetails = this.userDetails.loadUserByUsername(user.getUsername());
        String jwt = JwtUtil.createJWT(JSON.toJSONString(userDetails));

        return Rsg.Ok(new UserVo(user.getUsername(),jwt));
    }

    @PostMapping("/register")
    public Rsg register(){

        return Rsg.Imperror();
    }

    @PostMapping("/logout")
    public Rsg Login(){


        return Rsg.Imperror();
    }



}
