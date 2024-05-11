package com.oukelaile.vebAdmin.service.system;

import com.oukelaile.vebAdmin.ao.system.SysPassWordAo;
import com.oukelaile.vebAdmin.ao.system.SysUserInfoAo;
import com.oukelaile.vebAdmin.vo.system.SysUserInfoVo;


public interface UserService {

    SysUserInfoVo getUserInfo();

    Object updateById(SysUserInfoAo ao);

    Object updateAvatar(SysUserInfoAo ao);

    Object updatePassword(SysPassWordAo ao);

}
