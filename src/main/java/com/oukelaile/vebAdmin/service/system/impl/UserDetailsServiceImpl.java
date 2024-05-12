package com.oukelaile.vebAdmin.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.oukelaile.vebAdmin.entity.system.LoginUser;
import com.oukelaile.vebAdmin.entity.system.User;
import com.oukelaile.vebAdmin.exception.Custom.CustomResException;
import com.oukelaile.vebAdmin.mapper.system.UserMapper;
import com.oukelaile.vebAdmin.utils.vo.ResponseEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        //根据用户名查询用户信息
        LambdaQueryWrapper<User> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(User::getUsername,username);
        User user = userMapper.selectOne(wrapper);
        //如果查询不到数据就通过抛出异常来给出提示
        if(Objects.isNull(user)){
            throw new CustomResException(ResponseEnum.LOGIN_ERROR);
        }

        //查询到该角色的权限信息
        List<String> perms = userMapper.selectPermsByUserId(user.getId());
        //List<String> perms = new ArrayList<>();
        //perms.add("hai");
        //封装成UserDetails对象返回
        return new LoginUser(user, perms);
    }
}