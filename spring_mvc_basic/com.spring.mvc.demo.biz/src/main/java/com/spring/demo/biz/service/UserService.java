package com.spring.demo.biz.service;

import java.util.List;
import java.util.Map;

import com.spring.demo.biz.dto.User;

/**
 * @author cissalc    liuxiangfei
 */
public interface UserService {

	/**
	 * @param userId
	 * @param pwd
	 * @return
	 * @throws ExtServiceException
	 */
	public boolean authenticate(String userId, String pwd)
			throws ServiceException;

	/**
	 * 根据用户的UID找到用户的基本信息
	 * 
	 * @param userId
	 * @return
	 * @throws EOABusinessServiceException
	 */
	public User getUser(String userId) throws ServiceException;

	/**
	 * 分页查询用户信息
	 * @param params
	 * @return
	 * @throws ServiceException
	 */
	public List<User> queryUserPaginate(Map<String,String> params) throws ServiceException;
	
	/**
	 * 查询没有部门的用户信息
	 * @return
	 */
	public List<User> getNoDeptUser();
	
	/**
	 * 根据部门查询员工
	 * @param params
	 * @return
	 */
	public List<User> getUserByDeptCode(Map<String,String> params);
	
	/**
	 * 保存用户信息
	 * @param user
	 * @throws ServiceException
	 */
	public void saveUserInfo(User user) throws ServiceException;

	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUserInfo(User user);
	
	/**
	 * 修改密码
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public String pwdModefy(User user) throws ServiceException;
	/**
	 * 重设密码
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public String resetPwd(User user) throws ServiceException;
	
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
