package com.taotao.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;

public interface ItemService {

	TbItem getItemById(long itemId);
	
	EasyUIDataGridResult getItems(int page, int rows);
	
	TaotaoResult  addItem(TbItem tbitem, String desc);
}
