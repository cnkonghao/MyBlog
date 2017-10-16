package com.blog.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.FeedsMapper;
import com.blog.pojo.Feeds;
import com.blog.service.FeedsService;
import com.blog.utils.DateUtil;
import com.github.pagehelper.PageHelper;

@Service
public class FeedsServiceImpl implements FeedsService{
	
	@Autowired
	private FeedsMapper feedsMapper;

	//确认用户是否登陆
	@Override
	public int checkUser(Feeds record) {
		int t = feedsMapper.checkUser(record);
		if(t==0) {
			System.out.println("用户未登录");
		}else if(t>0){
			System.out.println("用户已登陆");
		}
		return t;
	}

	//增加留言
	@Override
	public void addFeeds(Feeds record) {
		record.setCreatedAt(DateUtil.dateToStamp(new Date()));
		feedsMapper.insertSelective(record);
	}

	//分页
	@Override
	public List<Feeds> queryByPage(Integer pageNo, Integer pageSize) {
		 pageNo = pageNo == null?1:pageNo;
		    pageSize = pageSize == null?10:pageSize;
		    PageHelper.startPage(pageNo, pageSize);
		    List<Feeds> list = feedsMapper.selectAll();
		    return list;
	}

}
