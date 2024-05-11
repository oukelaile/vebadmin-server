package com.oukelaile.demo2403.controller.shop;

import com.oukelaile.demo2403.query.ShopQuery;
import com.oukelaile.demo2403.service.shop.ShopService;
import com.oukelaile.demo2403.utils.vo.List;
import com.oukelaile.demo2403.utils.vo.ResponseEnum;
import com.oukelaile.demo2403.vo.shop.ShopVo;
import com.oukelaile.demo2403.vo.shop.page.ShopPageVo;
import com.oukelaile.demo2403.vo.system.ResponseVo;
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
