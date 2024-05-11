package com.oukelaile.demo2403.ao.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysPassWordAo {
    /**
     * 旧密码
     */
    String oldPassword;
    /**
     * 新密码
     */
    String newPassword;
    /**
     * 确认密码
     */
    String confirmPassword;
}
