package com.spring.demo.integration.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;

import com.spring.demo.biz.dto.User;

/**
 * 系统用户的数据访问对象.
 * 
 * @author cissalc    liuxiangfei
 */
public interface UserDAO {

	/**
	 * 查询所有用户.
	 * 
	 * @param userName
	 */
	public User insertAUser(User u);

	/**
	 * 使用系统登录账号查询用户.
	 * 
	 * @param userName
	 */
	public User queryUser(@Param("userId") String userId);

	/**
	 * 查询所有用户.
	 * 
	 * @param userName
	 */
	public List<User> queryAllUserList();

	
	/**
	 * 分页查询用户信息
	 * @param params
	 * @return
	 */
	public List<User> queryUserPaginate(Map<String,String> params);
	
	/**
	 * 分页查询总记录数
	 * @param params
	 * @return
	 */
	public String queryUserPaginateCount(Map<String,String> params);
	
	/**
	 * 根据部门查询员工
	 * @param params
	 * @return
	 */
	public List<User> getUserByDeptCode(Map<String,String> params);

	/**
	 * 获取么有部门的员工
	 * @return
	 */
	public List<User> getNoDeptUser();
	
	/**
	 * 更新用户信息
	 * @param user
	 */
	public void updateUser(User user);
	
	/**
	 * 清空部门用户信息
	 * @param user
	 */
	public void updateUserNoDept(User user);
	
	/**
	 * 查询所有有效用户
	 * @return
	 */
	public List<User> queryAllValidUserList();
	
	
}
