package com.oukelaile.vebAdmin.ao;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ShopAo {


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

}
