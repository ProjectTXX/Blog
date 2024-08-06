package com.group.blogapi.controller;

import cn.hutool.core.date.DateTime;
import com.alibaba.fastjson.JSON;
import com.group.blogapi.domain.User;
import com.group.blogapi.domain.vo.UserVo;
import com.group.blogapi.mapper.UserMapper;
import com.group.blogapi.service.UserService;
import com.group.blogapi.util.JwtUtil;
import com.group.blogapi.util.MailUtil;
import com.group.blogapi.util.Rsg;
import com.group.blogapi.util.VerificationCodeGenerator;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/api/v1/user")
public class UserController {

    @Autowired
    UserDetailsService userDetails;
    @Autowired
    private MailUtil mailUtil;

    @Autowired
    private UserService userService;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private UserMapper userMapper;

    @PostMapping("/login")
    public Rsg login(@RequestBody User user){
        System.out.println("登录接口" + user);
        UserDetails userDetails = this.userDetails.loadUserByUsername(user.getUsername());
        String jwt = JwtUtil.createJWT(JSON.toJSONString(userDetails));
        System.out.println(user);
        return Rsg.Ok(new UserVo(user.getUsername(),jwt));
    }

    @PostMapping("/register")
    public Rsg register(@RequestBody User user){
        System.out.println("注册接口" + user);
        user.setCreateTime(DateTime.now());
        user.setUpdateTime(DateTime.now());
        user.setNickname("tom");
        user.setAvatar("dkfjd");
        user.setRole("ROLE_admin");
        userService.registerUser(user);
        return Rsg.Ok("注册成功");
        //TODO 邮箱与avatar 互换
    }
    @GetMapping("/code")
    public Rsg sendCodeByEmail(@RequestParam String email){
        System.out.println("发送邮箱验证码接口" + email);
        String code = VerificationCodeGenerator.generateFiveDigitCode();
        System.out.println(code);
//        redisTemplate.opsForValue().set("code@" + email,code,5, TimeUnit.MINUTES);
        mailUtil.send(email,code);
        return Rsg.Ok(code);
    }

    @PostMapping("/logout")
    public Rsg Login(){


        return Rsg.Imperror();
    }



}
