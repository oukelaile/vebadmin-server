package com.oukelaile.demo2403.mapper.system;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.oukelaile.demo2403.entity.system.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    List<String> selectPermsByUserId(Long id);

}