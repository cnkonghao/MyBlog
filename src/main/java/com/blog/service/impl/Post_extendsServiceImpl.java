package com.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.Post_extendsMapper;
import com.blog.pojo.Post_extends;
import com.blog.service.Post_extendsService;

@Service
public class Post_extendsServiceImpl implements Post_extendsService{

	@Autowired
	private Post_extendsMapper post_extendsMapper;
	
	@Override
	public boolean postBrowserAdd(int postId) {
		if (post_extendsMapper.updateBrowserByPostId(postId)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean postCollectAdd(int postId) {
		if (post_extendsMapper.updateCollectByPostId(postId)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean postPraiseAdd(int postId) {
		if (post_extendsMapper.updatePraiseByPostId(postId)) {
			return true;
		}
		return false;
	}

	@Override
	public boolean postCommentAdd(int postId) {
		if (post_extendsMapper.updateCommentByPostId(postId)) {
			return true;
		}
		return false;
	}

	@Override
	public Post_extends getPostextendsById(int id) {
		return post_extendsMapper.selectByPrimaryKey(id);
	}

	@Override
	public void addPostextends(Post_extends post_extends) {
		post_extendsMapper.insertSelective(post_extends);
	}

	@Override
	public boolean deletePostextends(int id) {
		post_extendsMapper.deleteByPrimaryKey(id);
		return true;
	}

}
