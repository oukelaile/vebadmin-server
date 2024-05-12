package com.oukelaile.vebAdmin.controller.shop;

import com.oukelaile.vebAdmin.query.ShopQuery;
import com.oukelaile.vebAdmin.service.shop.ShopService;
import com.oukelaile.vebAdmin.utils.vo.List;
import com.oukelaile.vebAdmin.utils.vo.ResponseEnum;
import com.oukelaile.vebAdmin.vo.shop.ShopVo;
import com.oukelaile.vebAdmin.vo.shop.page.ShopPageVo;
import com.oukelaile.vebAdmin.vo.system.ResponseVo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("shop")
public class ShopController {

    @Resource
    ShopService shopService;

    @GetMapping("/{id}")
    public Object selectById(@PathVariable("id") Integer id) {
        ShopVo vo = shopService.selectById(id);
        return ResponseVo.response(ResponseEnum.SUCCESS, vo);
    }

    @PostMapping("/findByPage")
    public Object findByPage(@RequestBody ShopQuery query) {
        List<ShopPageVo> pageVo = shopService.findByPage(query);
        return ResponseVo.response(ResponseEnum.SUCCESS, pageVo);
    }
}
