package com.taotao.service.impl;

import java.util.Date;
import java.util.List; 

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.IDUtils;
import com.taotao.mapper.TbItemDescMapper;
import com.taotao.mapper.TbItemMapper;
import com.taotao.pojo.TbItem;
import com.taotao.pojo.TbItemDesc;
import com.taotao.service.ItemService;

/***
 * @Service 替代bean标签
 * @author lenovo
 *
 */
@Service
public class ItemServiceImpl implements ItemService {

	@Autowired
	private TbItemMapper tbItemMapper;
	@Autowired
	private TbItemDescMapper tbItemDescMapper;
	@Override
	public TbItem getItemById(long itemId) {
		  
		TbItem tbItem=tbItemMapper.geTbItemById(itemId);

		return tbItem;
	}
	@Override
	public EasyUIDataGridResult getItems(int page, int rows) {
		//设置分页信息
		PageHelper.startPage(page, rows);
		//得到所有商品信息
		List<TbItem> item=tbItemMapper.getTbItemPaging();
		//取分页信息
		PageInfo<TbItem> pageInfo = new PageInfo<>(item);	
		//创建返回结果对象
		EasyUIDataGridResult result = new EasyUIDataGridResult();
		result.setTotal(pageInfo.getTotal());
		result.setRows(item);
		return result;
		
		
	}
	@Override
	public TaotaoResult addItem(TbItem tbitem, String desc) {
		 long itemId=IDUtils.genItemId();
		 tbitem.setId(itemId);
		 tbitem.setStatus((byte)1);
		 Date date = new Date();
		 tbitem.setCreated(date);
		 tbitem.setUpdated(date);
		 
		 tbItemMapper.insertTbItem(tbitem);
		 
		 TbItemDesc tbItemDesc=new TbItemDesc();
		 tbItemDesc.setItemId(itemId);
		 tbItemDesc.setItemDesc(desc);
         tbItemDesc.setCreated(date);		
         tbItemDesc.setUpdated(date);
         
         tbItemDescMapper.insertTbItemDesc(tbItemDesc);
         return TaotaoResult.ok();
		
		
	}

}
