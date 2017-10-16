package com.blog.service.impl;

import java.util.List;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.blog.dao.CatsMapper;
import com.blog.pojo.Cats;
import com.blog.service.ICatsService;

@Configuration
@RunWith(SpringJUnit4ClassRunner.class)
@Service
@ContextConfiguration(locations = "classpath:applicationContext.xml")


public class CatsServiceImpl implements ICatsService{

	@Autowired
	private CatsMapper catsMapper;
	@Override
	public void deleteByPrimaryKey(Integer id) {
		catsMapper.deleteByPrimaryKey(id);
	}

	@Override
	public void insert(Cats record) {
		catsMapper.insert(record);
	}

	@Override
	public void insertSelective(Cats record) {
		catsMapper.insertSelective(record);
	}

	@Override
	public Cats selectByPrimaryKey(Integer id) {
		return catsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void updateByPrimaryKeySelective(Cats record) {
		catsMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public void updateByPrimaryKey(Cats record) {
		catsMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Cats> selectAll() {
		return catsMapper.selectAll();
	}

	@Override
	public Cats getCatById(int id) {
		return catsMapper.selectByPrimaryKey(id);
	}


	

	
}
