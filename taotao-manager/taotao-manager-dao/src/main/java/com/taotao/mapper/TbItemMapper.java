package com.taotao.mapper;



import java.util.List;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem; 



public interface TbItemMapper {
	/***
	 * 根据商品id查询商品信息
	 * @param itemId
	 * @return
	 */
	TbItem geTbItemById(long itemId);
	/**
	 * 分页查询商品信息
	 * @param page
	 * @param rows
	 * @return
	 */
	List<TbItem> getTbItemPaging();
	
	void insertTbItem(TbItem tbitem);
	
}