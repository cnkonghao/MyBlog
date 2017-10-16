package com.blog.service.impl;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.dao.TagsMapper;
import com.blog.pojo.Tags;
import com.blog.service.ITagsService;
@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")


public class TagsServiceImpl implements ITagsService{
	@Autowired
	private TagsMapper tagsMapper;
	@Override
	public void deleteByPrimaryKey(Integer id) {
		tagsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void insert(Tags record) {
		tagsMapper.insert(record);
	}

	@Override
	public void insertSelective(Tags record) {
		tagsMapper.insertSelective(record);
	}

	@Override
	public Tags selectByPrimaryKey(Integer id) {
		return tagsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateByPrimaryKeySelective(Tags record) {
		tagsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void updateByPrimaryKey(Tags record) {
		tagsMapper.updateByPrimaryKey(record);
	}

	
	@Override
	public void updatePost_numByTagName(String tagName) {
		tagsMapper.updatePost_numByTagName(tagName);
	}



	@Override
	public int selectByTagName(String tagName) {
		if (null==tagsMapper.selectByTagName(tagName)) {
			Tags newtag=new Tags();
			newtag.setTagName(tagName);
			newtag.setPostNum(1);
			tagsMapper.insert(newtag);
			return tagsMapper.selectByTagName(tagName).getId();
		}else{
			tagsMapper.updatePost_numByTagName(tagName);
			return tagsMapper.selectByTagName(tagName).getId();
		}
	}

	

	@Override
	public List<Tags> tags(String tagName) {
		return tagsMapper.tags(tagName);
	}

	@Override
	public List<Tags> getTagName() {
		return tagsMapper.selectTagName();
	}

	


}
