package com.blog.dao;

import java.util.List;

import com.blog.pojo.Admin;

public interface AdminMapper {
	/**
	 * 根据id删除
	 * @param id
	 * @return 返回受影响的行数（删除的行数）
	 */
    int deleteByPrimaryKey(Integer id);

    /**
	 * 插入管理员
	 * @param record
	 * @return 返回受影响的行数（插入的行数）
	 */
    int insert(Admin record);

    /**
     * 插入不为空的字段
     * @param record
     * @return 返回受影响的行数（插入的行数）
     */
    int insertSelective(Admin record);

    /**
     * 根据id查询数据
     * @param id
     * @return 返回一条数据
     */
    Admin selectByPrimaryKey(Integer id);

    /**
     * 修改数据
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(Admin record);

    /**
     * 修改数据
     * @param record
     * @return
     */
    int updateByPrimaryKey(Admin record);
    
    /**
     * 检查用户名是否存在
     * @param username
     * @return 返回用户名存在的次数
     */
    Admin checkUsername(String username);
    
    /**
     * 检查用户名和密码是否匹配
     * @param admin
     * @return 是则返回数据否则返回null
     */
    Admin checkPassword(Admin admin);
    
    /**
     * 检查用户状态是否为可用状态
     * @param username
     * @return
     */
    Admin checkStatus(String username);

	List<Admin> selectAll();

	int updateValid(Admin admin);
    
}