package com.bobo.shop.service.impl;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.bobo.shop.service.ShopService;
import com.bobo.shop.vo.ShopVO;
import com.github.pagehelper.PageInfo;
/**
 * 启动spring容器
 * @ClassName: ShopServiceImplTest 
 * @Description: TODO
 * @author: charles
 * @date: 2019年9月28日 上午11:15:02
 */
//spring和junit的整合类.用来便捷的启动spring容器
@RunWith(SpringJUnit4ClassRunner.class)
//spring容器所在的位置
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class ShopServiceImplTest {
	
	@Resource
	private ShopService shopService;
	
	

	@Test
	public void testSelects() {
		PageInfo<ShopVO> info = shopService.selects(null, null, 1, 3);
		System.out.println(info);
		
	}

}
