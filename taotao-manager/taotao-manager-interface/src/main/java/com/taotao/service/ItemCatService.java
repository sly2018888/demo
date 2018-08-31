package com.taotao.service;

import java.util.List;

import com.taotao.common.pojo.EasyUITreeNode;

public interface ItemCatService {

	/**
	 * 查询分类类目 返回json集合数据
	 * @param parentId
	 * @return
	 */
	List<EasyUITreeNode> getCatList(long parentId);
}
