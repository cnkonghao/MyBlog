package com.blog.service;

import com.blog.pojo.Post_extends;

public interface Post_extendsService {

	public boolean postBrowserAdd(int postId);//浏览量+1
	
	public boolean postCollectAdd(int postId);//收藏量+1
	
	public boolean postPraiseAdd(int postId);//点赞量+1
	
	public boolean postCommentAdd(int postId);//评论量+1
	
	public Post_extends getPostextendsById(int id);//根据id查询文章扩展内容
	
	public void addPostextends(Post_extends post_extends);//添加文章扩展内容
	
	public boolean deletePostextends(int id); //删除文章扩展内同
}
