package com.taotao.mapper;


import com.taotao.pojo.TbContent;

import java.util.List;

public interface TbContentMapper {

    /**
     * 根据指定内容分类查询分类下所有内容
     * @param categoryId 分类内容ID
     * @return
     */
        List<TbContent> findTbContentAll(long categoryId);

        void addContent(TbContent tbContent);



}