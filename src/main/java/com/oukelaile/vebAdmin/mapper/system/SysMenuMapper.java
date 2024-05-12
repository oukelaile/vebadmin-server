package com.oukelaile.vebAdmin.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oukelaile.vebAdmin.entity.system.SysMenu;
import com.oukelaile.vebAdmin.query.system.SysMenuQuery;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    List<SysMenu> selectMenuNormalAll();

    List<SysMenu> selectAllList(@Param("param") SysMenuQuery sysMenuQuery);

}