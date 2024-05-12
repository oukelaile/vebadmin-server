package com.oukelaile.vebAdmin.service.system;

import com.oukelaile.vebAdmin.entity.system.User;

import java.util.Map;

public interface LoginService {

    Map<String,String> login(User user);

    void logout();

}
