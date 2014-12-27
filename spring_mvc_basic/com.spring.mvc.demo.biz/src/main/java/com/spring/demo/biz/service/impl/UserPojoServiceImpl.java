package com.spring.demo.biz.service.impl;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.stereotype.Service;

import com.spring.demo.biz.dto.User;
import com.spring.demo.biz.service.ServiceException;
import com.spring.demo.biz.service.UserService;
import com.spring.demo.integration.dao.UserDAO;

/**
 * @author cissalc    liuxiangfei
 * 
 */
@Service
public class UserPojoServiceImpl implements UserService {

	/**
     * 
     */
	private Logger logger = org.apache.log4j.Logger.getLogger(this.getClass()
			.getName());
	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * 
	 */
	public UserPojoServiceImpl() {
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.demo.biz.service.UserService#authenticate(java.lang.String,
	 * java.lang.String)
	 */
	public boolean authenticate(String userId, String cred)
			throws ServiceException {
		try {
			if (cred == null || cred.isEmpty()) {
				return false;
			}
			// 先查询用户出来.
			boolean result = false;
			User user = userDAO.queryUser(userId);
			if (user == null || user.getPassword() == null) {
				logger.warn("用户不存在或者数据库中用户密码为空, 用户登录账号为");
				logger.warn(userId);
				result = false;
			} else {
				// 先判断用户的密码是否使用了标准的Salt-SHA算法
				if (user.getPassword().startsWith("{SSHA}")) {
					logger.debug("密码为SSHA散列值");
					LdapShaPasswordEncoder encoder = new LdapShaPasswordEncoder();
					result = encoder.isPasswordValid(user.getPassword(), cred,
							null);
				} else {
					logger.debug("密码为明文.");
					result = user.getPassword().equals(cred);
				}
			}
			if (logger.isDebugEnabled()) {
				logger.debug("密码验证结果为");
				logger.debug(String.valueOf(result));
			}
			return result;
		} catch (Exception ex) {
			logger.warn("用户身份验证失败", ex);
			throw new ServiceException(ex);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.spring.demo.biz.service.UserService#getUser(java.lang.String)
	 */
	public User getUser(String userId) throws ServiceException {
		try {
			if (userId == null || userId.isEmpty()) {
				logger.warn("输入的系统用户登录账号为空.");
				return null;
			}
			User user = userDAO.queryUser(userId);
			if (user == null) {
				logger.warn("系统中不存在此用户");
				logger.warn(userId);
			}
			return user;
		} catch (Exception ex) {
			logger.warn("查找用户失败", ex);
			throw new ServiceException(ex);
		}
	}
	
	/**
	 * 分页查询用户信息
	 * @param params
	 * @return
	 * @throws ServiceException
	 */
	public List<User> queryUserPaginate(Map<String,String> params) throws ServiceException{
		//校验参数
		
		return this.userDAO.queryUserPaginate(params);
	}

	/**
	 * 查询没有部门的用户信息
	 * @return
	 */
	public List<User> getNoDeptUser(){
		return this.userDAO.getNoDeptUser();
	}
	
	/**
	 * 根据部门查询员工
	 * @param params
	 * @return
	 */
	public List<User> getUserByDeptCode(Map<String,String> params){
		return this.userDAO.getUserByDeptCode(params);
	}
	
	/**
	 * 保存用户信息
	 * @param user
	 * @throws ServiceException
	 */
	public void saveUserInfo(User user) throws ServiceException{
		String userId = user.getUserId();
		User u = this.userDAO.queryUser(userId);
		if(u == null){
			user.setPassword(setDefaultPwd());//初始密码
			this.userDAO.insertAUser(user);
		}else{
			this.userDAO.updateUser(user);
		}
	}
	
	private String setDefaultPwd(){
		LdapShaPasswordEncoder encoder = new LdapShaPasswordEncoder();
		return encoder.encodePassword("123456", String.valueOf(System.currentTimeMillis()).getBytes());
	}
	
	/**
	 * 修改用户信息
	 * @param user
	 */
	public void updateUserInfo(User user){
		this.userDAO.updateUser(user);
	}

	
	/**
	 * 修改密码
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public String pwdModefy(User user) throws ServiceException{
		//校验原来密码是否正确
		boolean result = this.authenticate(user.getUserId(), user.getPassword());
		if(!result){
			return "2";
		}
		LdapShaPasswordEncoder encoder = new LdapShaPasswordEncoder();
		user.setPassword(encoder.encodePassword(user.getNewPassword(),
				String.valueOf(System.currentTimeMillis()).getBytes()));
		this.userDAO.updateUser(user);
		return "1";
	}
	
	/**
	 * 重设密码
	 * @param user
	 * @return
	 * @throws ServiceException
	 */
	public String resetPwd(User user) throws ServiceException{
		user.setPassword(setDefaultPwd());
		this.userDAO.updateUser(user);
		return "1";
	}

	/**
	 * 清空部门用户信息
	 * @param user
	 */
	public void updateUserNoDept(User user){
		this.userDAO.updateUserNoDept(user);
	}
	
	/**
	 * 查询所有有效用户
	 * @return
	 */
	public List<User> queryAllValidUserList(){
		return this.userDAO.queryAllValidUserList();
	}

	
}
