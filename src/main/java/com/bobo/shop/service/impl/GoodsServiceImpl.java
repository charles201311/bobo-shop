package com.bobo.shop.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.bobo.shop.dao.GoodsMapper;
import com.bobo.shop.domain.Goods;
import com.bobo.shop.service.GoodsService;

@Service
public class GoodsServiceImpl implements GoodsService {
	@Resource
	private GoodsMapper goodsMapper;

	@Override
	public List<Goods> selects() {
		return goodsMapper.selects();
	}

}
