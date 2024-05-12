package com.oukelaile.demo2403.entity.system;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.oukelaile.demo2403.enums.DelFlag;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SysMenu {

	/**
	 * 菜单id
	 */
	@TableId(type = IdType.AUTO)
	private Long menuId;

	/**
	 * 菜单名
	 */
	private String menuName;

	/**
	 * 父菜单id
	 */
	private Long parentMenuId;


	/**
	 * 路由路径
	 */
	private String routerPath;

	/**
	 * 路由名称
	 */
	private String routerName;

	/**
	 * 路由组件
	 */
	private String routerComponent;


	/**
	 * 菜单类型
	 */
	private char menuType;

	/**
	 * 菜单图标
	 */
	private String menuIcon;

	/**
	 * 显示顺序
	 */
	private Integer menuOrder;

	/**
	 * 是否隐藏 0显示1隐藏
	 */
	private Integer hide;

	/**
	 *
	 */
	private DelFlag delFlag;

	/**
	 *
	 */
	@TableField(exist = false)
	private List<SysMenu> children;

}
