package com.oukelaile.vebAdmin.controller.system;

import com.oukelaile.vebAdmin.entity.system.User;
import com.oukelaile.vebAdmin.service.system.LoginService;
import com.oukelaile.vebAdmin.utils.vo.ResponseEnum;
import com.oukelaile.vebAdmin.vo.system.ResponseVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/")
public class LoginController {

    @Resource
    LoginService loginService;

    /**
     * 登录接口
     */
    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        Map<String, String> login = loginService.login(user);
        return ResponseVo.response(ResponseEnum.SUCCESSFUL, login);
    }

    /**
     * 退出登录接口
     */
    @PostMapping("/logout")
    public Object logout() {
        loginService.logout();
        return ResponseVo.success("退出登录成功");
    }

}
