package com.taotao.content.service;

import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

public interface ContentCategoryService {

	List<EasyUITreeNode> getContentCategoryList(long parentId);
	
	/**
	 * 添加内容分类信息 
	 * @param parentId  父级类目id
	 * @param name 分类名称
	 * @return
	 */
	TaotaoResult addContentCategory(long parentId, String name);


	
}
