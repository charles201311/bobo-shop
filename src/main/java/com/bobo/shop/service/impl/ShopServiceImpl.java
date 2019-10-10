package com.bobo.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bobo.shop.dao.ShopMapper;
import com.bobo.shop.domain.Shop;
import com.bobo.shop.service.ShopService;
import com.bobo.shop.vo.ShopVO;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class ShopServiceImpl implements ShopService {

	@Resource
	private ShopMapper shopMapper;
	@Override
	public PageInfo<ShopVO> selects(String name, Integer[] gids, Integer page, Integer pageSize) {
         PageHelper.startPage(page, pageSize);
         List<ShopVO> lists = shopMapper.selects(name, gids) ;
         PageInfo<ShopVO> info = new PageInfo<ShopVO>(lists);
		return  info;
	}
	@Override
	public boolean insert(Shop shop, Integer[] gids) {
		
		try {
			
			//1.增加商铺.,并返回商品的ID
			shopMapper.insert(shop);
			
			//2.增加商品
			for(int i=0;i<gids.length;i++) {
			  shopMapper.insertMiddle(shop.getId(), gids[i]);
			}
			return true;
			
		} catch (Exception e) {
	      e.printStackTrace();
	      //抛异常.事务回滚
	      throw new RuntimeException("保存失败"+e.getMessage());
		}
		
	}
	@Override
	public boolean delete(Integer[] sids) {
		
		try {
			
			//1.删除商铺
			shopMapper.deletePatch(sids);
			
			//2删除该商铺的所有商品
			for(int i =0 ;i<sids.length;i++) {
				shopMapper.deleteMiddle(sids[i]);	
			}
			return true;
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException("删除失败.....");
		}
		
	}
	@Override
	public ShopVO selectById(Integer id) {
		// TODO Auto-generated method stub
		return shopMapper.selectById(id);
	}

}
