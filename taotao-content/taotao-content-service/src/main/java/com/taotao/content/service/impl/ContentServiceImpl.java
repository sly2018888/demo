package com.taotao.content.service.impl;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.common.utils.JsonUtils;
import com.taotao.content.service.ContentService;
import com.taotao.jedis.JedisClient;
import com.taotao.mapper.TbContentMapper;
import com.taotao.pojo.TbContent;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.List;

@Service
public class ContentServiceImpl implements ContentService {

    @Value("${CONTENT_KEY}")
    private String CONTENT_KEY;
    @Autowired
    private JedisClient jedisClient;
    @Autowired
    private TbContentMapper tbContentMapper;
    @Override
    public EasyUIDataGridResult findContentAll(long categoryId) {
        List<TbContent> list = tbContentMapper.findTbContentAll(categoryId);
        EasyUIDataGridResult result=new EasyUIDataGridResult();
        result.setTotal(list.size());
        result.setRows(list);

        return result;
    }
    @Override
    public TaotaoResult addContent(TbContent tbContent) {
       Date date=new Date();
      tbContent.setCreated(date);
      tbContent.setUpdated(date);
       tbContentMapper.addContent(tbContent);
        return TaotaoResult.ok();
    }
    @Override
    public List<TbContent> getTbContent(long categoryId) {
       //这里取缓存
       //第一次请求，由于没有缓存直接查询数据库  完成后再return前，把数据库的数据加入到redis缓存中
        try {
            String json=jedisClient.hget(CONTENT_KEY,categoryId+"");
           //判断json是否存在
            if(StringUtils.isNotBlank(json)){
                List<TbContent> list=JsonUtils.jsonToList(json,TbContent.class);
                System.out.println("从缓存中取出redis");
                return list;
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }
        List<TbContent> result= tbContentMapper.findTbContentAll(categoryId);
        System.out.println("查询数据库");
        try {
            //这里加缓存  把list集合变成json字符串
            jedisClient.hset(CONTENT_KEY,categoryId+"", JsonUtils.objectToJson(result));
            System.out.println("加入redis缓存");
        }catch (Exception e1){
            e1.printStackTrace();
        }finally {
            
        }
        return result;
    }
}
