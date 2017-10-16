package com.blog.dao;

import java.util.List;

import com.blog.pojo.Feeds;

public interface FeedsMapper {
	/**
	 * 确认用户是否登陆
	 * @param userid
	 * @return 
	 */
	int checkUser(Feeds record);
	
	/**
	 * 删除留言
	 * @param id
	 * @return
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * 增加留言
     * @param record
     * @return
     */
	int insert(Feeds record);
	
	/**
	 * 查询所有留言
	 * @return
	 */
	List<Feeds> selectAll();

	int insertSelective(Feeds record);

	Feeds selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Feeds record);

	int updateByPrimaryKey(Feeds record);

	
}