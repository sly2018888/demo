package com.taotao.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.alibaba.dubbo.container.page.Page;
import com.sun.webkit.ContextMenu.ShowContext;
@Controller
public class PageController {

	@RequestMapping("/")
	public String  ShowIndex(){
		return "index";
	}
	@RequestMapping("/{page}")
	public String showPage(@PathVariable String page){
		return page;
	}
}
