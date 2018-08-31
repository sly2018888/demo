package com.taotao.content.service;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.pojo.TbContent;

import java.util.List;

public interface ContentService {

    EasyUIDataGridResult findContentAll(long categoryId);

    TaotaoResult addContent(TbContent tbContent);

    /**
     *
     * 根据cid查询内容
     * @param categoryId
     * @return
     */
    List<TbContent> getTbContent(long categoryId);
}
