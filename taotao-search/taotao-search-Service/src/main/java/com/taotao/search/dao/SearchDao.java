package com.taotao.search.dao;

import com.taotao.common.pojo.SearchItem;
import com.taotao.common.pojo.SearchResult;
import net.sf.jsqlparser.expression.operators.relational.ItemsList;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.SolrDocument;
import org.apache.solr.common.SolrDocumentList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Repository
public class SearchDao {

    /**
     * 根据业务传入条件查询文档库
     *
     * @param query
     * @return
     */
    @Autowired
    private SolrServer solrServer;

    public SearchResult search(SolrQuery query) {
        SearchResult result = new SearchResult();
        try {
            //根据query对象查询索引库
            QueryResponse queryResponse = solrServer.query(query);

            //取商品列表
            SolrDocumentList documentList = queryResponse.getResults();

            //商品列表
            List<SearchItem> list = new ArrayList<SearchItem>();
            for (SolrDocument solrDocument : documentList) {
                SearchItem item = new SearchItem();
                item.setId((String) solrDocument.get("id"));
                item.setCategory_name((String) solrDocument.get("item_category_name"));
                item.setImage((String) solrDocument.get("item_image"));
                item.setPrice((Long) solrDocument.get("item_price"));
                item.setSell_point((String) solrDocument.get("item_sell_point"));
                //有高亮显示的内容时。
                Map<String, Map<String, List<String>>> highlighting = queryResponse.getHighlighting();
                List<String> list1 = highlighting.get(solrDocument.get("id")).get("item_title");
                String itemTitle = "";
                if (list1 != null && list1.size() > 0) {
                    itemTitle = list1.get(0);
                } else {
                    itemTitle = (String) solrDocument.get("item+title");
                }
                item.setTitle(itemTitle);
                list.add(item);

            }
            result.setItemList(list);
            //总记录条数
            result.setRecordCount(documentList.getNumFound());
            return result;
        } catch (SolrServerException e) {
            e.printStackTrace();
        }
         return null;
    }
}
