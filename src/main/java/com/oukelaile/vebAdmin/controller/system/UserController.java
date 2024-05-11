package com.oukelaile.vebAdmin.controller.system;

import com.oukelaile.vebAdmin.ao.system.SysPassWordAo;
import com.oukelaile.vebAdmin.ao.system.SysUserInfoAo;
import com.oukelaile.vebAdmin.service.system.UserService;
import com.oukelaile.vebAdmin.utils.vo.ResponseEnum;
import com.oukelaile.vebAdmin.vo.system.ResponseVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("user")
public class UserController {

    @Resource
    UserService userService;

    @PostMapping("/getInfo")
    public Object getInfo() {
        return ResponseVo.response(ResponseEnum.SUCCESSFUL, userService.getUserInfo());
    }

    @PostMapping("updateById")
    public Object updateById(@RequestBody SysUserInfoAo ao) {
        return ResponseVo.response(ResponseEnum.SUCCESSFUL, userService.updateById(ao));
    }

    @PostMapping("updateAvatar")
    public Object updateAvatar(@RequestBody SysUserInfoAo ao) {
        return ResponseVo.response(ResponseEnum.SUCCESSFUL, userService.updateAvatar(ao));
    }

    @PostMapping("updatePassword")
    public Object updatePassword(@RequestBody SysPassWordAo ao) {
        return ResponseVo.response(ResponseEnum.SUCCESSFUL, userService.updatePassword(ao));
    }

}
