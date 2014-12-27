package com.spring.demo.integration.dao.impl;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.spring.demo.biz.dto.User;
import com.spring.demo.biz.service.ServiceException;
import com.spring.demo.integration.dao.UserDAO;

/**
 * @author cissalc    liuxiangfei
 */
@Repository
public class UserMybatisDAOImpl extends MyBatisBaseDAO implements UserDAO {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.spring mvc.rule.company.integration.dao.UserDAO#queryUser(java.lang.
	 * String)
	 */
	public User queryUser(String userId) {
		return this.getSqlSession().selectOne("queryUser", userId);
	}

	/**
	 * 
	 */
	
	public User insertAUser(User u) {
		this.getSqlSession().insert("insertUser", u);
		return u;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.demo.biz.integration.dao.UserDAO#queryAllUserList()
	 */
	
	public List<User> queryAllUserList() {
		return this.getSqlSession().selectList("queryAllUserList");
	}

	/**
	 * 分页查询用户信息
	 * @param params
	 * @return
	 * @throws ServiceException
	 */
	
	public List<User> queryUserPaginate(Map<String,String> params){
		return this.getSqlSession().selectList("queryUserPaginate",params);
	}
	
	/**
	 * 获取没有部门的员工
	 * @return
	 */
	
	public List<User> getNoDeptUser(){
		return this.getSqlSession().selectList("getNoDeptUser");
	}
	
	/**
	 * 根据部门查询员工
	 * @param params
	 * @return
	 */
	
	public List<User> getUserByDeptCode(Map<String,String> params){
		return this.getSqlSession().selectList("getUserByDeptCode", params);
	}
	
	/**
	 * 分页查询总记录数
	 * @param params
	 * @return
	 */
	
	public String queryUserPaginateCount(Map<String,String> params){
		return this.getSqlSession().selectOne("queryUserPaginateCount", params);
	}

	/**
	 * 更新用户信息
	 * @param user
	 */
	
	public void updateUser(User user){
		this.getSqlSession().update("updateUser",user);
	}

	/**
	 * 清空部门用户信息
	 * @param user
	 */
	
	public void updateUserNoDept(User user){
		this.getSqlSession().update("updateUserNoDept",user);
	}

	/**
	 * 查询所有有效用户
	 * @return
	 */
	
	public List<User> queryAllValidUserList(){
		return this.getSqlSession().selectList("queryAllValidUserList");
	}
}
