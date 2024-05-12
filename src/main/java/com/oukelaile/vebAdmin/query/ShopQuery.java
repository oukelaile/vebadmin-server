package com.oukelaile.vebAdmin.query;

import com.oukelaile.vebAdmin.query.base.PageQuery;
import lombok.Data;
import lombok.EqualsAndHashCode;


@Data
@EqualsAndHashCode(callSuper = true)
public class ShopQuery extends PageQuery {

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
