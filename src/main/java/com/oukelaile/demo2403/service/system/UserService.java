package com.oukelaile.demo2403.service.system;

import com.oukelaile.demo2403.ao.system.SysPassWordAo;
import com.oukelaile.demo2403.ao.system.SysUserInfoAo;
import com.oukelaile.demo2403.vo.system.SysUserInfoVo;


public interface UserService {

    SysUserInfoVo getUserInfo();

    Object updateById(SysUserInfoAo ao);

    Object updateAvatar(SysUserInfoAo ao);

    Object updatePassword(SysPassWordAo ao);

}
