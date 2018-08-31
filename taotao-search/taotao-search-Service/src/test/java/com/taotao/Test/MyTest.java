package com.taotao.Test;

import org.apache.solr.client.solrj.SolrServer;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.common.SolrInputDocument;
import org.junit.Test;

import java.io.IOException;

public class MyTest {

    /*
    @Test
    public void demo1() throws IOException, SolrServerException {
       //把数据库的数据导入   往solr里面添加索引库和文档库
        // 第一步：把solrJ的jar包添加到工程中。
        // 第二步：创建一个SolrServer，使用HttpSolrServer创建对象。
        SolrServer solrServer=new HttpSolrServer("http://192.168.25.154:8080/solr");
        //文档库存放  域名+域值
        // 第三步：创建一个文档对象SolrInputDocument对象。
        SolrInputDocument doc=new SolrInputDocument();
        // 第四步：向文档中添加域。必须有id域，域的名称必须在schema.xml中定义。
        doc.addField("id","01");
        doc.addField("item_title","蜡烛");
       doc.addField("item_price","2");
        solrServer.add(doc);
        solrServer.commit();
    }

    @Test
    public void demo2() throws IOException, SolrServerException {

        SolrServer solrServer=new HttpSolrServer("http://192.168.25.154:8080/solr");
        solrServer.deleteById("01");
       solrServer.commit();


    }*/
}
