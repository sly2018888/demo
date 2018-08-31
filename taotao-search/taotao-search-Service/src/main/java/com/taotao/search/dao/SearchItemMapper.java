package com.taotao.search.dao;

import com.taotao.common.pojo.SearchItem;
import com.taotao.common.pojo.SearchResult;
import org.apache.solr.client.solrj.SolrQuery;

import java.util.List;

public interface SearchItemMapper {

    List<SearchItem> getItemList();

    /**
     * 根据业务传入条件查询文档库
     * @param query
     * @return
     */
    public SearchResult search(SolrQuery query);
}
