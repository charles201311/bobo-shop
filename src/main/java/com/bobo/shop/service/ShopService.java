package com.bobo.shop.service;

import com.bobo.shop.domain.Shop;
import com.bobo.shop.vo.ShopVO;
import com.github.pagehelper.PageInfo;

public interface ShopService {
	
	/**
	 * 单个商铺的ID
	 * @Title: selectById 
	 * @Description: TODO
	 * @param id
	 * @return
	 * @return: ShopVO
	 */
	ShopVO selectById(Integer id);
	/**
	 * 批量删除商铺
	 * @Title: delete 
	 * @Description: TODO
	 * @param sids
	 * @return
	 * @return: boolean
	 */
	boolean delete(Integer[] sids);
	
	
	/**
	 * 增加商铺和所售商品
	 * @Title: insert 
	 * @Description: TODO
	 * @param shop
	 * @param gids
	 * @return
	 * @return: boolean
	 */
	boolean insert(Shop shop,Integer gids[]);
	
	
	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询店面集合
	 * @param name
	 * @param gids
	 * @return
	 * @return: List<ShopVO>
	 */
	PageInfo<ShopVO> selects(String name,Integer gids[],Integer page ,Integer pageSize);

}
