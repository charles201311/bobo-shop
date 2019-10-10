package com.bobo.shop.dao;

import java.util.List;

import com.bobo.shop.domain.Goods;

public interface GoodsMapper {
	/**
	 * 查询所有的商品
	 * @Title: selects 
	 * @Description: TODO
	 * @return
	 * @return: List<Goods>
	 */
	List<Goods> selects();

}
