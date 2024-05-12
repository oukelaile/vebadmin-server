package com.oukelaile.vebAdmin.service.system.impl;

import com.alibaba.fastjson.JSON;
import com.oukelaile.vebAdmin.entity.system.LoginUser;
import com.oukelaile.vebAdmin.entity.system.User;
import com.oukelaile.vebAdmin.service.system.LoginService;
import com.oukelaile.vebAdmin.utils.JwtUtils;
import com.oukelaile.vebAdmin.utils.RedisUtils;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Resource
    AuthenticationManager authenticationManager;
    @Resource
    RedisUtils redisUtils;

    @Override
    public Map<String, String> login(User user) {
        //3使用ProviderManager authenticate方法进行验证  返回一个Authentication对象，其中包含了认证通过的用户信息
        UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(user.getUsername(),user.getPassword());
        Authentication authenticate = authenticationManager.authenticate(usernamePasswordAuthenticationToken);

        //校验失败了
        //if(Objects.isNull(authenticate)){
        //    throw new CustomResException(ResponseEnum.LOGIN_ERROR);
        //}

        //4自己生成jwt给前端
        LoginUser loginUser= (LoginUser)(authenticate.getPrincipal());
        String userId = loginUser.getUser().getId().toString();
        String jwt = JwtUtils.createJWT(userId);
        Map<String,String> map=new HashMap();
        map.put("token",jwt);
        //5系统用户相关所有信息放入redis
        redisUtils.set("login:"+userId, JSON.toJSONString(loginUser));

        //return new ResponseResult(200, "登陆成功", map);
        return map;
    }

    @Override
    public void logout() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        LoginUser loginUser = (LoginUser) authentication.getPrincipal();
        Long userId = loginUser.getUser().getId();
        redisUtils.delete("login:" + userId);
    }
}
