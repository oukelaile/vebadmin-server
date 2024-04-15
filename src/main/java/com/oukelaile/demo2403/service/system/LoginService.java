package com.oukelaile.demo2403.service.system;

import com.oukelaile.demo2403.entity.system.User;
import org.omg.CORBA.Object;

import java.util.Map;

public interface LoginService {
    Map<String,String> login(User user);

    void logout();

}
