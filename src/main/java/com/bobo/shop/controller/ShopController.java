package com.bobo.shop.controller;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.bobo.shop.domain.Goods;
import com.bobo.shop.domain.Shop;
import com.bobo.shop.service.GoodsService;
import com.bobo.shop.service.ShopService;
import com.bobo.shop.util.PageUtil;
import com.bobo.shop.vo.ShopVO;
import com.github.pagehelper.PageInfo;
import com.google.gson.Gson;
//aaaaaaaa
//ccccc
@Controller
public class ShopController {

	@Resource
	private ShopService shopService;
	
	@Resource
	private GoodsService goodsService;
	
	
	//详情
	@GetMapping("shopDetail")
	public String shopDetail(Integer id,Model model) {
		
		ShopVO shopVO = shopService.selectById(id);
		model.addAttribute("shop", shopVO);
		return "shopdetail";
		
	}
	
	@RequestMapping("selects")
	public String selects(HttpServletRequest request,String  name,Integer gids[],Model model,@RequestParam(defaultValue = "1")Integer page,@RequestParam(defaultValue = "3")Integer pageSize) {
		
		PageInfo<ShopVO> info = shopService.selects(name, gids, page, pageSize);
		//分页
		PageUtil.page(request, "/selects", pageSize, info.getList(), (int)info.getTotal(), page);
		model.addAttribute("shops",info.getList());//存储集合
		model.addAttribute("name",name);//查询条件合
		
		//用来处理商品的ID,最终拼接成字符串   " 1,2,3,"
		StringBuffer sb = new StringBuffer();
		if(gids!=null) {
			
		for (Integer i : gids) {
			sb.append(i+",");	
		}
		
		String str=sb.toString();
		//去掉最后一个, 放入model域中
		model.addAttribute("gids",str.substring(0,str.length()-1));//查询条件
		}
		return "shops";
	
	}
	
	
	
	/**
	 * 去增加
	 * @Title: add 
	 * @Description: TODO
	 * @return
	 * @return: String
	 */
	@GetMapping("add")
	public String add(Model model) {
		List<Goods> goods = goodsService.selects();
		model.addAttribute("goods", goods);
		
		return "add";
		
	}
	
	/**
	 * 执行增加
	 * @Title: add 
	 * @Description: TODO
	 * @param shop
	 * @param gids
	 * @return
	 * @return: boolean
	 */
	@ResponseBody
	@PostMapping("add")
	public boolean add(Shop shop,Integer[] gids) {
		return  shopService.insert(shop, gids);
	}
	
	/**
	 *查询出所有商品
	 * @Title: selectsGoods 
	 * @Description: TODO
	 * @return
	 * @return: List<Goods>
	 */
	@ResponseBody
	@RequestMapping("selectsGoods")
	public List<Goods> selectsGoods(){
		//查询出所有商品
	 return goodsService.selects();

	}
	
	/**
	 * 批量删除
	 * @Title: deletePatch 
	 * @Description: TODO
	 * @return
	 * @return: List<Goods>
	 */
	@ResponseBody
	@RequestMapping("deletePatch")
	public boolean deletePatch(@RequestParam("sids[]")Integer[]  sids){
		//查询出所有商品
	 return shopService.delete(sids);
	}
}
