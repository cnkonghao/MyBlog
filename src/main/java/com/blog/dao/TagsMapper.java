package com.blog.dao;

import java.util.List;

import com.blog.pojo.Tags;

public interface TagsMapper {
	
	int deleteByPrimaryKey(Integer id);

	int insert(Tags record);

	int insertSelective(Tags record);

	Tags selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Tags record);

	int updateByPrimaryKey(Tags record);
	/**
	 * 根据标签名字查文章id
	 * @param Tag_name
	 * @return
	 */
	List<Tags> tags(String tag_name);
	/**
	 * 查找所有标签名字按文章数目排序
	 * @return
	 */
	List<Tags> selectTagName();
	/**
	 * 根据标签名字查找
	 * @param tagName
	 * @return
	 */
	Tags selectByTagName(String tagName);
	/**
	 * 根据标签名字增加，增加文章数量
	 * @param tagName
	 * @return
	 */
	int updatePost_numByTagName(String tagName);
}