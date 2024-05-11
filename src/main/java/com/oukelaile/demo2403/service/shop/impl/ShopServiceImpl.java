package com.oukelaile.demo2403.service.shop.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.oukelaile.demo2403.entity.Shop;
import com.oukelaile.demo2403.mapper.ShopMapper;
import com.oukelaile.demo2403.query.ShopQuery;
import com.oukelaile.demo2403.service.shop.ShopService;
import com.oukelaile.demo2403.utils.StringUtils;
import com.oukelaile.demo2403.utils.vo.List;
import com.oukelaile.demo2403.utils.vo.CommonPageUtils;
import com.oukelaile.demo2403.vo.shop.ShopVo;
import com.oukelaile.demo2403.vo.shop.page.ShopPageVo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class ShopServiceImpl extends ServiceImpl<ShopMapper, Shop> implements ShopService {

    @Resource
    ShopMapper shopMapper;

    @Override
    public ShopVo selectById( Integer id) {
        Shop entity = shopMapper.selectById(id);
        return ShopVo.buildVo(entity);
    }

    @Override
    public List<ShopPageVo> findByPage(ShopQuery query) {
        IPage<Shop> pages = new Page<>(query.getCurrentPage(), query.getPageSize());
        ShopQuery newQuery = StringUtils.convertEmptyToNull(query);
        pages = shopMapper.findByPage(pages, newQuery);
        return CommonPageUtils.assemblyPage(pages.convert(ShopPageVo::buildVo));
    }

}
