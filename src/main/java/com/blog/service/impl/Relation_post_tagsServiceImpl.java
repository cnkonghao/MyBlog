package com.blog.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.Relation_post_tagsMapper;
import com.blog.pojo.Relation_post_tags;
import com.blog.service.IRelation_post_tagsService;
@Service
public class Relation_post_tagsServiceImpl implements IRelation_post_tagsService{

	@Autowired
	private Relation_post_tagsMapper relation_post_tagsMapper;

	@Override
	public void deleteByPrimaryKey(Integer id) {

		relation_post_tagsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void insert(Relation_post_tags record) {
		relation_post_tagsMapper.insert(record);
	}

	@Override
	public void insertSelective(Relation_post_tags record) {
		relation_post_tagsMapper.insertSelective(record);
	}

	@Override
	public Relation_post_tags selectByPrimaryKey(Integer id) {

		return relation_post_tagsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateByPrimaryKeySelective(Relation_post_tags record) {
		relation_post_tagsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void updateByPrimaryKey(Relation_post_tags record) {
		relation_post_tagsMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Relation_post_tags> selectPostIdByTagId(Integer tagId) {
		return relation_post_tagsMapper.selectPostIdByTagId(tagId);
	}

	@Override
	public List<Relation_post_tags> selectTagIdByPostId(Integer postId) {
		return relation_post_tagsMapper.selectTagIdByPostId(postId);
	}

	@Override
	public void deleteByPostId(Integer id) {
		relation_post_tagsMapper.deleteByPostId(id);
	}

	@Override
	public void addRelations(int postId, int tagId) {
		Relation_post_tags relation_post_tags = new Relation_post_tags();
		relation_post_tags.setPostId(postId);
		relation_post_tags.setTagId(tagId);
		relation_post_tagsMapper.insertSelective(relation_post_tags);
	}

}
