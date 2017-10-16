package com.blog.service;

import java.util.List;

import com.blog.pojo.Comment;

public interface CommentService {

	public void addComment(Comment comment);//添加评论
	
	public List<Comment> getCommentByPostId(int postId);//根据id查询评论
}
