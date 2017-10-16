package com.blog.dao;

import java.util.List;

import com.blog.pojo.Comment;

public interface CommentMapper {
    int deleteByPrimaryKey(Integer id);//根据主键id删除

    int insert(Comment record);//添加（可为空）

    int insertSelective(Comment record);//添加（不可为空）

    Comment selectByPrimaryKey(Integer id);//根据主键id查询
    
    List<Comment> selectByPostId(Integer id);//根据post_id查询

    int updateByPrimaryKeySelective(Comment record);//更新

    int updateByPrimaryKeyWithBLOBs(Comment record);//更新

    int updateByPrimaryKey(Comment record);//更新（connect不变）
    
}