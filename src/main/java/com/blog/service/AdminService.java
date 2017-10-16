package com.blog.service;

import java.util.List;

import com.blog.pojo.Admin;

public interface AdminService {
	
	 Admin selectById(Integer userid);
	/**
     * 检查管理员是否存在
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
	 * 添加管理员
	 * @param user
	 */
	public void addAdmin(Admin admin);
    
    /**
     * 检查用户状态是否为可用状态
     * @param username
     * @return
     */
    Admin checkStatus(String username);
    
    void UpdateAdmin(Admin admin);

    List<Admin> selectAll();
}
