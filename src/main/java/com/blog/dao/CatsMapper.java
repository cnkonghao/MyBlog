package com.blog.dao;

import java.util.List;

import com.blog.pojo.Cats;

public interface CatsMapper {
    int deleteByPrimaryKey(Integer id);//根据id删除

    int insert(Cats record);//添加

    int insertSelective(Cats record);

    Cats selectByPrimaryKey(Integer id);//根据id查找

    int updateByPrimaryKeySelective(Cats record);//根据id修改

    int updateByPrimaryKey(Cats record);//根据id修改

    List<Cats> selectAll();//根据类的名字查到文章的id

	
    
    
}