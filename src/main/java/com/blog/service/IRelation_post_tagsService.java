package com.blog.service;

import java.util.List;

import com.blog.pojo.Relation_post_tags;

public interface IRelation_post_tagsService {
	public void deleteByPrimaryKey(Integer id);

	public void insert(Relation_post_tags record);

	public void insertSelective(Relation_post_tags record);

	public Relation_post_tags selectByPrimaryKey(Integer id);

	public void updateByPrimaryKeySelective(Relation_post_tags record);

	public void updateByPrimaryKey(Relation_post_tags record);
	/**
	 * 根据标签id查找文章的id
	 * @param tagId
	 * @return
	 */
	public  List<Relation_post_tags> selectPostIdByTagId(Integer tagId);
	/**
	 * 根据文章的id找到标签的id
	 * @param tagId
	 * @return
	 */
	public List<Relation_post_tags> selectTagIdByPostId(Integer postId);
	/**
	 * 根据文章id删除
	 * @param id
	 * @return
	 */
	public void deleteByPostId(Integer id);
	
	public void addRelations(int postId ,int tagId);
}
