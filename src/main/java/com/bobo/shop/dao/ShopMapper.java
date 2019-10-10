package com.bobo.shop.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.bobo.shop.domain.Shop;
import com.bobo.shop.vo.ShopVO;

public interface ShopMapper {
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
	 * 删除商铺
	 * @Title: deletePatch 
	 * @Description: TODO
	 * @param sids
	 * @return
	 * @return: int
	 */
	int deletePatch(Integer sids[]);
	/**
	 * 删除中间
	 * @Title: deleteMiddle 
	 * @Description: TODO
	 * @param sid
	 * @return
	 * @return: int
	 */
	int deleteMiddle(Integer sid);
	/**
	 * 增加商铺
	 * @Title: insert 
	 * @Description: TODO
	 * @param shop
	 * @return
	 * @return: int
	 */
	int insert(Shop shop);
	
	/**
	 * 中间表
	 * @Title: insetMiddle 
	 * @Description: TODO
	 * @param sid 商铺ID
	 * @param gid 商品ID
	 * @return
	 * @return: int
	 */
	int insertMiddle(@Param("sid")Integer sid,@Param("gid")Integer gid);

	/**
	 * 
	 * @Title: selects 
	 * @Description: 查询店面集合
	 * @param name
	 * @param gids
	 * @return
	 * @return: List<ShopVO>
	 */
	List<ShopVO> selects(@Param("name") String name,@Param("gids")Integer gids[]);
}
