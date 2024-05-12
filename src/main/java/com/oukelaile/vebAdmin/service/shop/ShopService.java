package com.oukelaile.vebAdmin.service.shop;

import com.baomidou.mybatisplus.extension.service.IService;
import com.oukelaile.vebAdmin.entity.Shop;
import com.oukelaile.vebAdmin.query.ShopQuery;
import com.oukelaile.vebAdmin.utils.vo.List;
import com.oukelaile.vebAdmin.vo.shop.ShopVo;
import com.oukelaile.vebAdmin.vo.shop.page.ShopPageVo;

public interface ShopService extends IService<Shop> {

    ShopVo selectById(Integer id);


    List<ShopPageVo> findByPage(ShopQuery query);

}
