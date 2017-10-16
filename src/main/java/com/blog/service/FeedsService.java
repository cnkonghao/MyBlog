package com.blog.service;

import java.util.List;

import com.blog.pojo.Feeds;

public interface FeedsService {
	
	/**
	 * 确认用户是否登陆
	 * @param userid
	 * @return 
	 */
	int checkUser(Feeds record);
	
	/**
	 * 分页
	 * @param pageNo
	 * @param pageSize
	 * @return
	 */
	public List<Feeds> queryByPage(Integer pageNo,Integer pageSize);
	
	/**
     * 增加留言
     * @param record
     * @return
     */
	void addFeeds(Feeds record);
	
	

}
