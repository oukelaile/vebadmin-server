package com.oukelaile.demo2403.service.shop;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oukelaile.demo2403.entity.Shop;
import com.oukelaile.demo2403.query.ShopQuery;
import com.oukelaile.demo2403.utils.vo.List;
import com.oukelaile.demo2403.vo.shop.ShopVo;
import com.oukelaile.demo2403.vo.shop.page.ShopPageVo;

public interface ShopService extends IService<Shop> {

    ShopVo selectById(Integer id);


    List<ShopPageVo> findByPage(ShopQuery query);

}
