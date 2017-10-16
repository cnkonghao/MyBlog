package com.blog.service;

import java.util.List;

import com.blog.pojo.Cats;

public interface ICatsService {
	/**
	 * 根据id删除
	 * @param id
	 */
	public void deleteByPrimaryKey(Integer id);
	/**
	 * 添加
	 * @param record
	 */

	public void insert(Cats record);

	public void insertSelective(Cats record);
	/**
	 * 根据id查找
	 * @param id
	 * @return
	 */

	public Cats selectByPrimaryKey(Integer id);
	/**
	 * 根据id修改
	 * @param record
	 */

	public void updateByPrimaryKeySelective(Cats record);
	/**
	 * 根据id修改
	 * @param record
	 */

	public void updateByPrimaryKey(Cats record);
	/**
	 * 根据类的名字查到文章的id
	 * @param name
	 * @return
	 */

	public  List<Cats> selectAll();
	
	public Cats getCatById(int id);
}
