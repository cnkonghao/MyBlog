package com.blog.service.impl;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.CommentMapper;
import com.blog.pojo.Comment;
import com.blog.service.CommentService;

@Service
public class CommentServiceImpl implements CommentService{

	@Autowired
	private CommentMapper commentMapper;
	
	@Override
	public void addComment(Comment comment) {
		commentMapper.insertSelective(comment);
	}

	@Override
	public List<Comment> getCommentByPostId(int postId) {
		return commentMapper.selectByPostId(postId);
	}

}
