package com.blog.service.impl;

import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.blog.dao.AdminMapper;
import com.blog.pojo.Admin;
import com.blog.service.AdminService;
import com.blog.utils.MD5Util;
import com.blog.utils.DateUtil;


@Service
public class AdminServiceImpl implements AdminService{
	
	@Autowired
	private AdminMapper adminMapper;

	public Admin selectById(Integer userid) {
		return adminMapper.selectByPrimaryKey(userid);
	}
	//判断用户是否存在
	@Override
	public Admin checkUsername(String username) {	
		Admin admin = adminMapper.checkUsername(username);
		return admin;
	}

	//判断用户名和密码是否验证成功
	@Override
	public Admin checkPassword(Admin admin) {
		admin.setPasswordHash(MD5Util.string2MD5(admin.getPasswordHash()));
		return adminMapper.checkPassword(admin);
	}

	//添加管理员
	@Override
	public void addAdmin(Admin admin) {
		admin.setPasswordHash(MD5Util.string2MD5(admin.getPasswordHash()));
		admin.setCreatedAt(DateUtil.dateToStamp(new Date()));
		admin.setUpdatedAt(DateUtil.dateToStamp(new Date()));
		adminMapper.insertSelective(admin);
	}

	//判断管理员权限(启用禁用)
	@Override
	public Admin checkStatus(String username) {
		// TODO Auto-generated method stub
		Admin admin = adminMapper.checkStatus(username);
		short status = admin.getStatus();
		if(status==1) {
			admin.setStatus((short) 0);
			adminMapper.updateValid(admin);
		}else if(status==0) {
			admin.setStatus((short) 1);
			adminMapper.updateValid(admin);
		}
		return admin;
	}
	
	//修改管理员信息
	public void UpdateAdmin(Admin admin) {
		if (StringUtils.isNotBlank(admin.getPasswordHash())) {
			admin.setPasswordHash(MD5Util.string2MD5(admin.getPasswordHash()));
		}
		adminMapper.updateByPrimaryKeySelective(admin);
	}
	
	//根据id查找Admin
	public Admin selectAdmin(Integer id) {
		Admin admin = adminMapper.selectByPrimaryKey(id);
		return admin;
	}
	
	//删除用户资料
	public void DeleteAdmin(Integer id) {
		adminMapper.deleteByPrimaryKey(id);
	}
	
	@Override
	public List<Admin> selectAll() {
		return adminMapper.selectAll();
	}

}
