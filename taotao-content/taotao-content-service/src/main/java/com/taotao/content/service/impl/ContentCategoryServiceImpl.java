package com.taotao.content.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentCategoryService;
import com.taotao.mapper.TbContentCategoryMapper;
import com.taotao.pojo.TbContentCategory;
@Service
public class ContentCategoryServiceImpl implements ContentCategoryService {

	@Autowired 
	private TbContentCategoryMapper tbContentCategoryMapper;
	@Override
	public List<EasyUITreeNode> getContentCategoryList(long parentId) {
		
		List<TbContentCategory> contentCategories=tbContentCategoryMapper.getTbContentCategoryByParentId(parentId);
		List<EasyUITreeNode> result=new ArrayList<EasyUITreeNode>();
		for (TbContentCategory tbContentCategory : contentCategories) {
			EasyUITreeNode node=new EasyUITreeNode();
			node.setId(tbContentCategory.getId());
			node.setText(tbContentCategory.getName());
			node.setState(tbContentCategory.getIsParent()?"closed":"open");
			result.add(node);
		
		}
		
		return result;
	}
	@Override
	public TaotaoResult addContentCategory(long parentId, String name) {
		
		//补充数据
	TbContentCategory tbContentCategory=new TbContentCategory();
	tbContentCategory.setIsParent(false);
	tbContentCategory.setName(name);
	tbContentCategory.setStatus(1);
	tbContentCategory.setParentId(parentId);
	tbContentCategory.setSortOrder(1);
	Date date=new Date();
	tbContentCategory.setCreated(date);
	tbContentCategory.setUpdated(date);
	//插入数据到数据库
	tbContentCategoryMapper.addTbContentCategary(tbContentCategory);
	
	//页面传两个值，parentId为当前内容分类的id name就是分类名称   修改父级目录
	TbContentCategory parentNodeCategory=tbContentCategoryMapper.getTbContentCategoryById(parentId);
	//如果不是父节点   则改为父节点
	if(!parentNodeCategory.getIsParent()){
		tbContentCategory.setId(parentId);
		tbContentCategory.setIsParent(true);
		tbContentCategoryMapper.updateTbContentCategory(tbContentCategory);
	}
	//回传页面  显示
		return TaotaoResult.ok(tbContentCategory);
	}


}
