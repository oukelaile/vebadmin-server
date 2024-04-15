package com.oukelaile.demo2403.vo.shop;

import com.oukelaile.demo2403.entity.Shop;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopVo {


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

	public static ShopVo buildVo(Shop entity) {
		ShopVo vo = new ShopVo();
		BeanUtils.copyProperties(entity, vo);
		return vo;
	}

}
