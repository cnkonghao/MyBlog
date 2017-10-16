package com.blog.service;

import java.util.List;

import com.blog.pojo.Tags;

public interface ITagsService {

	public void deleteByPrimaryKey(Integer id);

	public void insert(Tags record);

	public void insertSelective(Tags record);

	public Tags selectByPrimaryKey(Integer id);

	public void updateByPrimaryKeySelective(Tags record);

	public void updateByPrimaryKey(Tags record);

	public void updatePost_numByTagName(String tagName);

	public	List<Tags> tags(String tagName);
	
	public List<Tags> getTagName();

	public int  selectByTagName(String tagName);

}
