package com.taotao.search.service;

import com.taotao.common.pojo.SearchResult;

public interface SearchService {
    /**
     * 根据当前页面的需要和条件  返回商品集合总记录条数，总页数
     * @param queryString
     * @param page
     * @param rows
     * @return
     */
    public SearchResult search(String queryString, int page,int rows);

}
