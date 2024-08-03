package com.group.blogapi.service.imp;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.group.blogapi.domain.User;
import com.group.blogapi.domain.vo.LoginUser;
import com.group.blogapi.mapper.UserMapper;
import com.group.blogapi.util.JwtUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,username);
        User user = userMapper.selectOne(wrapper);
        //如果查询不到数据就通过抛出异常来给出提示
        if(Objects.isNull(user)){
            /**
             * 认证过程中ExceptionTranslationFilter会捕获异常
             * */
            throw new RuntimeException("用户名或密码错误");
        }
        //根据用户查询权限信息 添加到LoginUser中
        List<String > author = new ArrayList<>();
        author.add(user.getAuthentication());
        //封装成UserDetails对象返回
        return new LoginUser(user,author);
    }
}