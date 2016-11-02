package com.pinglun.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.pinglun.service.PingLunService;

@Controller
public class IndexController {

	@Autowired
	private PingLunService pingLunService;

	@RequestMapping("/index")
	public String showIndex() {

		return "index";
	}

	@RequestMapping(value="/content", method=RequestMethod.GET, produces={MediaType.TEXT_HTML_VALUE+";charset=utf-8"})
	@ResponseBody
	public String getHtml(@RequestParam(defaultValue="0") int pageNum, @RequestParam(defaultValue="10") int pageSize) {
		
		String string = pingLunService.getHtml(pageNum, pageSize);
		System.err.println(string);
		return string;
	}

}
