package com.oukelaile.demo2403.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oukelaile.demo2403.entity.Shop;
import com.oukelaile.demo2403.query.ShopQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopMapper extends BaseMapper<Shop> {

    IPage<Shop> findByPage(IPage<Shop> pages, @Param("params") ShopQuery newQuery);

}
