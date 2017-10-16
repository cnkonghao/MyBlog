package com.blog.dao;

import java.util.List;

import com.blog.pojo.Relation_post_tags;

public interface Relation_post_tagsMapper {
	int deleteByPrimaryKey(Integer id);

	int insert(Relation_post_tags record);

	int insertSelective(Relation_post_tags record);

	Relation_post_tags selectByPrimaryKey(Integer id);

	int updateByPrimaryKeySelective(Relation_post_tags record);

	int updateByPrimaryKey(Relation_post_tags record);
	/**
	 * 根据标签id查找文章的id
	 * @param tagId
	 * @return
	 */
	List<Relation_post_tags> selectPostIdByTagId(Integer tagId);
	/**
	 * 根据文章的id找到标签的id
	 * @param tagId
	 * @return
	 */
	List<Relation_post_tags> selectTagIdByPostId(Integer postId);
	/**
	 * 根据文章id删除
	 * @param id
	 * @return
	 */
	int deleteByPostId(Integer id);
	
	
}