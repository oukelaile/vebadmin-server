package com.oukelaile.demo2403.mapper.system;

import  com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oukelaile.demo2403.entity.system.SysMenu;
import com.oukelaile.demo2403.query.system.SysMenuQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> selectMenuNormalAll();

    List<SysMenu> selectAllList(@Param("param") SysMenuQuery sysMenuQuery);

}