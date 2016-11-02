package com.pinglun.service.impl;

import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.chainsaw.Main;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pinglun.mapper.TbPinglunMapper;
import com.pinglun.mapper.TbShuoshuoMapper;
import com.pinglun.mapper.TbUserMapper;
import com.pinglun.pojo.TbShuoshuo;
import com.pinglun.pojo.TbShuoshuoExample;
import com.pinglun.pojo.TbShuoshuoExample.Criteria;
import com.pinglun.pojo.TbUser;
import com.pinglun.pojo.TbUserExample;
import com.pinglun.service.PingLunService;
import com.pinglun.service.pojo.Content;
import com.pinglun.util.FreemarkerUtil;

@Service
public class PingLunServiceImpl implements PingLunService {

	@Autowired
	private TbUserMapper userMapper;

	@Autowired
	private TbShuoshuoMapper shuoshuoMapper;


	@Override
	public String getHtml(int pageNum, int pageSize) {

		
		List<Content> contents = getShuoshuo(pageNum, pageSize);
		Map<String,List<Content>> map = new HashMap<>();
		map.put("list", contents);
		//使用freemarker必须用map或者javaBean来包装list
		String string = null;
		try {
			System.out.println(this.getClass().getClassLoader().getResource("").toURI());
			string = FreemarkerUtil.freemarker(map,this.getClass().getClassLoader().getResource("").toURI(),"index.ftlh");
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return string;
	}


	private List<Content> getShuoshuo(int pageNum, int pageSize) {
		//PageHelper.startPage(pageNum, pageSize);
		
		TbShuoshuoExample example = new TbShuoshuoExample();
		
		Criteria criteria = example.createCriteria();
		
		List<Content> contents = new ArrayList<Content>();
		
		List<TbShuoshuo> shuoshuos = shuoshuoMapper.selectByExampleWithBLOBs(example);
		
		System.out.println(shuoshuos.size());
		
		for (TbShuoshuo shuoshuo : shuoshuos) {
			Content content = new Content();
			content.setShuoshuo(shuoshuo);
			System.out.println(shuoshuo.getContent());
			TbUser user = userMapper.selectByPrimaryKey(shuoshuo.getUserId());
			content.setUser(user);
			System.out.println(user.getUsername());
			contents.add(content);
			
		}
		
		
		return contents;
	}
	

}
