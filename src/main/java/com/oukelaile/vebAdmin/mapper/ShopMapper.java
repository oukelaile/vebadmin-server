package com.oukelaile.vebAdmin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.oukelaile.vebAdmin.entity.Shop;
import com.oukelaile.vebAdmin.query.ShopQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface ShopMapper extends BaseMapper<Shop> {

    IPage<Shop> findByPage(IPage<Shop> pages, @Param("params") ShopQuery newQuery);

}
