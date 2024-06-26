package com.oukelaile.vebAdmin.vo.shop.page;

import com.oukelaile.vebAdmin.entity.Shop;
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
