package com.taotao.search.service;

import com.taotao.common.pojo.TaotaoResult;

public interface SearchItemService {

    //查询数据库并且导入索引库
    TaotaoResult importAllItems();
}
