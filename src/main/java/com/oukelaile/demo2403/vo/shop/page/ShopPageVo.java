package com.oukelaile.demo2403.vo.shop.page;

import com.oukelaile.demo2403.entity.Shop;
import com.oukelaile.demo2403.entity.system.SysMenu;
import com.oukelaile.demo2403.vo.system.page.SysMenuPageVo;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopPageVo {


	/**
	 * 主键id
	 */
	private Long id;

	/**
	 * 商品名
	 */
	private String name;


	/**
	 * 商品价格
	 */
	private Long price;

	/**
	 * 商品简介
	 */
	private String introduction;

	public static ShopPageVo buildVo(Shop vo) {
		ShopPageVo pageVo = new ShopPageVo();
		BeanUtils.copyProperties(vo, pageVo);
		return pageVo;
	}

}
