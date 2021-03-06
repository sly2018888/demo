package com.taotao.controller;

import java.io.Serializable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbItem;
import com.taotao.service.ItemService;

@Controller
@RequestMapping("/item")
public class ItemController implements Serializable{

	@Autowired
	private ItemService itemService;
	@RequestMapping("/{itemId}")
	@ResponseBody
	public TbItem geTbItemById(@PathVariable long itemId){
		TbItem tbItem=itemService.getItemById(itemId);
		return tbItem;
	}
	
	@RequestMapping("/list")
	@ResponseBody
	 public EasyUIDataGridResult getItemList(Integer page,Integer rows){
		EasyUIDataGridResult result=itemService.getItems(page, rows); 
		return result;
	 }
	
	@RequestMapping("/save")
	@ResponseBody
	public TaotaoResult addItem(TbItem tbItem,String desc){
		TaotaoResult result=itemService.addItem(tbItem, desc);
		return result;
	}
}
