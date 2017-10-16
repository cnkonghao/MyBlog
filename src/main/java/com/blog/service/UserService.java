package com.blog.service;

import com.blog.pojo.User;

public interface UserService {
	/**
     * 检查用户名和密码是否匹配
     * @param user
     * @return 返回查找出来的User数据
     */
	public User checkPassword(String username,String password);
	
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
	
    /**
     * 检查是否用户是否有权限操作
     * @param username
     * @return 返回权限值
     */
	public void checkStatus(String username);

	
}
