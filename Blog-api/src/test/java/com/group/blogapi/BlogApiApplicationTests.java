package com.group.blogapi;

import com.group.blogapi.util.MailUtil;
import com.group.blogapi.util.VerificationCodeGenerator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

@SpringBootTest
class BlogApiApplicationTests {


    @Autowired
    public RedisTemplate redisTemplate;

    @Autowired
    public MailUtil mailUtil;
    @Test
    void contextLoads() {
        String email = "1303733214@qq.com";
        String code = VerificationCodeGenerator.generateFiveDigitCode();
        redisTemplate.opsForValue().set("code",code,5, TimeUnit.MINUTES);
        System.out.println(mailUtil.send(email,code));

    }

}
