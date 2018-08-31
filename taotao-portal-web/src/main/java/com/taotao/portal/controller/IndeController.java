package com.taotao.portal.controller;

import com.taotao.common.utils.JsonUtils;
import com.taotao.content.service.ContentService;
import com.taotao.pojo.TbContent;
import com.taotao.portal.pojo.Ad1Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndeController {

    @Autowired
    private ContentService contentService;

    @Value("${AD1_CID}")
    private long AD1_CID;
    @Value("${AD1_HEIGHT}")
    private String AD1_HEIGHT;
    @Value("${AD1_WIDTH}")
    private String AD1_WIDTH;
    @Value("${AD1_HEIGHT_B}")
    private String AD1_HEIGHT_B;
    @Value("${AD1_WIDTH_B}")
    private String AD1_WIDTH_B;

    @RequestMapping("/index")
    public String showIndex(Model model){
        List<TbContent> tbContent= contentService.getTbContent(AD1_CID);
       List<Ad1Node> adList= new  ArrayList<Ad1Node>();
     for(TbContent tbContent1:tbContent) {
         Ad1Node node = new Ad1Node();
         node.setAlt(tbContent1.getTitle());
         node.setHeight(AD1_HEIGHT);
         node.setHeightB(AD1_HEIGHT_B);
         node.setWidth(AD1_WIDTH);
         node.setWidthB(AD1_WIDTH_B);
         node.getHref(tbContent1.getUrl());
         node.setSrc(tbContent1.getPic());
         node.getSrcB(tbContent1.getPic2());
         adList.add(node);
     }
     model.addAttribute("ad1", JsonUtils.objectToJson(adList));
     return "index";
    }

}
