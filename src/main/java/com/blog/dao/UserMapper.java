package com.blog.dao;

import com.blog.pojo.User;

public interface UserMapper {
	/**
	 * 根据id删除用户
	 * @param id
	 * @return 返回受影响的行数（删除的行数）
	 */
    int deleteByPrimaryKey(Integer id);

    /**
     * 插入用户（字段可以都为空）
     * @param record
     * @return 返回受影响的行数（增加的行数）
     */
    int insert(User record);

    /**
     * 插入用户(字段至少一个不为空)
     * @param record
     * @return 返回受影响的行数（插入的行数）
     */
    int insertSelective(User record);

    /**
     * 根据id查找用户
     * @param id
     * @return 返回查找出来的User数据
     */
    User selectByPrimaryKey(Integer id);

    /**
     * 修改（字段可以都为空）
     * @param record
     * @return 返回受影响的行数（修改的行数）
     */
    int updateByPrimaryKeySelective(User record);
    
    /**
     * 修改（字段至少一个不为空）
     * @param record
     * @return 返回受影响的行数（修改的行数）
     */
    int updateByPrimaryKey(User record);
    
    /**
     * 检查是否包含该用户
     * @param username
     * @return 返回受影响的行数（检查的行数）
     */
    User checkUsername(String username);
    
    /**
     * 检查用户名和密码是否匹配
     * @param user
     * @return 返回查找出来的User数据
     */
    User checkPassword(User user);
    
    /**
     * 检查是否用户是否有权限操作
     * @param username
     * @return 返回权限值
     */
    short checkStatus(String username);
    
    
}