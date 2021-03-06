package com.taotao.controller;

import com.taotao.common.pojo.EasyUIDataGridResult;
import com.taotao.common.pojo.TaotaoResult;
import com.taotao.content.service.ContentService;
import com.taotao.pojo.TbContent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/content")
public class ContentController {
    @Autowired
    private ContentService contentService;
    @RequestMapping("/query/list")
    @ResponseBody
    public EasyUIDataGridResult findAllContentCategoryById(Long categoryId){
        EasyUIDataGridResult result= contentService.findContentAll(categoryId);
        return result;
    }

    @RequestMapping("/save")
    public TaotaoResult addContent(TbContent tbContent){
        TaotaoResult result=contentService.addContent(tbContent);
        return result;
    }

}
