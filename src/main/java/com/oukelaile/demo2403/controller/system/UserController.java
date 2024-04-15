package com.oukelaile.demo2403.controller.system;

import com.oukelaile.demo2403.vo.system.ResponseVo;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("user")
public class UserController {

    @PostMapping("getInfo")
    public Object getInfo() {
        return ResponseVo.success();
    }

}
