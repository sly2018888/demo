package com.taotao.search.service.impl;

import com.taotao.common.pojo.SearchItem;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.search.dao.SearchItemMapper;
import com.taotao.search.service.SearchItemService;
import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;
@Service
public class SearchItemServiceImpl  implements SearchItemService{
    @Autowired
    private SearchItemMapper searchItemMapper;
    @Autowired
    private SolrServer solrServer;
    @Override
    public TaotaoResult importAllItems()  {
        List<SearchItem> searchItems=searchItemMapper.getItemList();
        try {
            for (SearchItem  search:searchItems) {
                SolrInputDocument doc=new SolrInputDocument();
                doc.addField("id",search.getId());
                doc.addField("item_title",search.getTitle());
                doc.addField("item_sellPoint",search.getSell_point());
                doc.addField("item_price",search.getPrice());
                doc.addField("item_image",search.getImage());
                doc.addField("item_category_name",search.getCategory_name());
                doc.addField("item_itemDesc",search.getItem_desc());
                solrServer.add(doc);
            }
            solrServer.commit();
        }catch (Exception e){
           e.printStackTrace();
        }
        return TaotaoResult.build(500, "导入数据失败");
    }
}
