package com.group.blogapi;

import com.alibaba.fastjson.JSONObject;
import com.group.blogapi.domain.vo.LoginUser;
import com.group.blogapi.util.JwtUtil;
import io.jsonwebtoken.Claims;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

//@SpringBootTest
class BlogApiApplicationTests {

    @Test
    void contextLoads() {
    }
    @Test
    void password(){
        PasswordEncoder p=new BCryptPasswordEncoder();
        String encode = p.encode("12345678");
        System.out.println(encode);

    }
    @Test
    void parseJwt() throws Exception {
        Claims claims = JwtUtil.parseJWT("eyJhbGciOiJIUzI1NiJ9.eyJqdGkiOiJjMDc5MTExYjQzNzg0YzZmOTQ5N2QzNGYzOWNjYjY3YyIsInN1YiI6IntcImFjY291bnROb25FeHBpcmVkXCI6dHJ1ZSxcImFjY291bnROb25Mb2NrZWRcIjp0cnVlLFwiY3JlZGVudGlhbHNOb25FeHBpcmVkXCI6dHJ1ZSxcImVuYWJsZWRcIjp0cnVlLFwicGFzc3dvcmRcIjpcIiQyYSQxMCRxMkh3YkhJNVkwZEhGb05OQjJna2llTW16Yy91STVaN2Y5b3ZQVnRELjl2LnJMZWQuYTloNlwiLFwicGVybWlzc2lvbnNcIjpbXCJST0xFX2FkbWluXCJdLFwidXNlclwiOntcImF1dGhlbnRpY2F0aW9uXCI6XCJST0xFX2FkbWluXCIsXCJhdmF0YXJcIjpcIi9pbWcvYXZhdGFyLmpwZ1wiLFwiY3JlYXRlVGltZVwiOjE2MDA2NzgwMzgwMDAsXCJpZFwiOjEsXCJwYXNzd29yZFwiOlwiJDJhJDEwJHEySHdiSEk1WTBkSEZvTk5CMmdraWVNbXpjL3VJNVo3ZjlvdlBWdEQuOXYuckxlZC5hOWg2XCIsXCJ1c2VybmFtZVwiOlwiQWRtaW5cIn0sXCJ1c2VybmFtZVwiOlwiQWRtaW5cIn0iLCJpc3MiOiJIdXRBZG1pbiIsImlhdCI6MTcyMjA0ODYwNywiZXhwIjoxNzIyOTEyNjA3fQ.L6DxQ4qbOrX5xoiOizCWRNJf3VM5DGywPF71yfwV7s0");
        System.out.println(claims);
        System.out.println(claims.getSubject());
        System.out.println(claims.get("token",String.class));
        LoginUser loginUser = JSONObject.parseObject(claims.getSubject(), LoginUser.class);
        System.out.println(loginUser);
    }

}
