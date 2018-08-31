package com.taotao.mapper;

import java.util.List;

import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContentCategory;

public interface TbContentCategoryMapper {

	/**
	 * 根据父级类目id查询分类信息
	 * @param parentId
	 * @return父级类目下的子类目
	 */
	List<TbContentCategory>   getTbContentCategoryByParentId(long parentId);
	/**
	 * 添加一个分类信息导数据库
	 * @param tbContentCategory  需要添加的分类对象
	 */
	void addTbContentCategary(TbContentCategory tbContentCategory);
/**
 * 根据当前id查询指定内容分类
 * @param parentId
 * @return
 */
	TbContentCategory getTbContentCategoryById(long parentId);

	void updateTbContentCategory(TbContentCategory tbContentCategory);
	
	TaotaoResult updateContentCategaryByName(Long id, String name);

}