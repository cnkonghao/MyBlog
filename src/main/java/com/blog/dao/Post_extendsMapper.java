package com.blog.dao;

import com.blog.pojo.Post_extends;

public interface Post_extendsMapper {
    int deleteByPrimaryKey(Integer id);//根据id删除
    
    int deleteByPostId(Integer post_id);//根据post_id删除

    int insert(Post_extends record);//添加（可为空）

    int insertSelective(Post_extends record);//添加（不可为空）

    Post_extends selectByPrimaryKey(Integer id);//根据主键id查询
    
    Post_extends selectByPostId(Integer post_id);//根据post_id查询

    int updateByPrimaryKeySelective(Post_extends record);

    int updateByPrimaryKey(Post_extends record);//修改
    
    boolean updateBrowserByPostId(Integer postId);//浏览量+1
    
    boolean updateCollectByPostId(Integer postId);//收藏量+1
    
    boolean updatePraiseByPostId(Integer postId);//点赞量+1
    
    boolean updateCommentByPostId(Integer postId);//评论量+1
}