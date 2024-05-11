package com.oukelaile.vebAdmin.service.system.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.oukelaile.vebAdmin.ao.system.SysPassWordAo;
import com.oukelaile.vebAdmin.ao.system.SysUserInfoAo;
import com.oukelaile.vebAdmin.entity.system.LoginUser;
import com.oukelaile.vebAdmin.entity.system.User;
import com.oukelaile.vebAdmin.mapper.system.UserMapper;
import com.oukelaile.vebAdmin.service.system.UserService;
import com.oukelaile.vebAdmin.vo.system.SysUserInfoVo;
import org.springframework.beans.BeanUtils;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    UserMapper userMapper;

    @Resource
    private PasswordEncoder passwordEncoder; // Spring Security提供的密码编码器

    @Override
    public SysUserInfoVo getUserInfo() {
        // 从SecurityContext中获取当前认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
                UserDetails userDetails = (UserDetails) principal;
                // 创建SysUserInfoVo对象并填充信息
                SysUserInfoVo userInfoVo = new SysUserInfoVo();
                // 使用BeanUtils
        Long id = ((LoginUser) userDetails).getUser().getId();
        User entity = userMapper.selectById(id);
        SysUserInfoVo vo = new SysUserInfoVo();
        BeanUtils.copyProperties(entity, vo);
        return vo;
    }


    @Override
    public Object updateById(SysUserInfoAo ao) {
        User entity = new User();
        BeanUtils.copyProperties(ao, entity);
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(User::getId, entity.getId())
                .set(User::getNickName, entity.getNickName())
                .set(User::getSex, entity.getSex())
                .set(User::getEmail, entity.getEmail())
                .set(User::getPhoneNumber, entity.getPhoneNumber());
        return userMapper.update(entity, lambdaUpdateWrapper) > 0;
    }

    @Override
    public Object updateAvatar(SysUserInfoAo ao) {
        User entity = new User();
        BeanUtils.copyProperties(ao, entity);
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(User::getId, entity.getId())
                .set(User::getAvatar, entity.getAvatar());
        return userMapper.update(entity, lambdaUpdateWrapper) > 0;
    }

    @Override
    public Object updatePassword(SysPassWordAo ao) {
        // 1. 验证输入，例如检查ao是否非空，新密码和确认密码是否一致等
        if (ao == null || !ao.getNewPassword().equals(ao.getConfirmPassword())) {
            throw new IllegalArgumentException("无效的输入或密码不匹配。");
        }

        // 从SecurityContext中获取当前认证信息
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        Object principal = authentication.getPrincipal();
        UserDetails userDetails = (UserDetails) principal;
        // 创建SysUserInfoVo对象并填充信息
        SysUserInfoVo userInfoVo = new SysUserInfoVo();
        // 使用BeanUtils
        Long currentUserID = ((LoginUser) userDetails).getUser().getId();

        // 2. 从数据库中查找用户，这里假设ao中包含用户ID
        User user = userMapper.selectById(currentUserID);
                //.orElseThrow(() -> new NoSuchElementException("User not found."));

        // 3. 验证旧密码是否正确
        if (!passwordEncoder.matches(ao.getOldPassword(), user.getPassword())) {
            throw new BadCredentialsException("旧密码不正确。");
        }

        // 4. 更新密码，使用密码编码器加密新密码
        user.setPassword(passwordEncoder.encode(ao.getNewPassword()));

        // 5. 保存更改到数据库
        LambdaUpdateWrapper<User> lambdaUpdateWrapper = new LambdaUpdateWrapper<>();
        lambdaUpdateWrapper.eq(User::getId, user.getId())
                .set(User::getPassword, user.getPassword());
        // 6. 返回操作结果或信息，这里简单返回true表示成功
        return userMapper.update(new User(), lambdaUpdateWrapper) > 0;
    }

}
