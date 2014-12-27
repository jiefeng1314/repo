package com.spring.demo.integration.dao.impl;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.demo.biz.dto.User;
import com.spring.demo.biz.service.UserService;
import com.spring.demo.integration.dao.UserDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:biz-context.xml" })
public class UserServiceTest {

	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private UserService userPojoServiceImpl;


	/**
	 * 
	 * @return
	 */
	protected User getTestUser3() {
		User u = new User();
		u.setUserId("MAXIAOQIANG_789789");
		u.setUserName("测试用户3");
		u.setDeptCode("DEPT_CODE3");
		u.setDeptName("DEPT_NAME3");
		u.setEmail("AA@spring mvc.com3");
		u.setEnabled("1");
		u.setMobilePhone("186123456783");
		u.setPassword("1234563");
		return u;
	}

	/**
	 * 
	 * @return
	 */
	protected User getTestUser2() {
		User u = new User();
		u.setUserId("MAXIAOQIANG_456456");
		u.setUserName("测试用户2");
		u.setDeptCode("DEPT_CODE2");
		u.setDeptName("DEPT_NAME2");
		u.setEmail("AA@spring mvc.com2");
		u.setEnabled("1");
		u.setMobilePhone("186123456782");
		u.setPassword("1234562");
		return u;
	}

	/**
	 * 
	 * @return
	 */
	protected User getTestUser1() {
		User u = new User();
		u.setUserId("MAXIAOQIANG_123123");
		u.setUserName("测试用户1");
		u.setDeptCode("DEPT_CODE1");
		u.setDeptName("DEPT_NAME1");
		u.setEmail("AA@spring mvc.com1");
		u.setEnabled("1");
		u.setMobilePhone("186123456781");
		u.setPassword("1234561");
		return u;
	}

	/**
	 * 
	 */
	@Test
	public void insertANewUser() {
		User u = new User();
		u.setUserId("111");
		u.setUserName("222");
		LdapShaPasswordEncoder encoder = new LdapShaPasswordEncoder();
		u.setPassword(encoder.encodePassword("123456",
				String.valueOf(System.currentTimeMillis()).getBytes()));
		u.setEnabled("1");
		u.setMobilePhone("");
		u.setEmail("");
		u.setDeptCode("");
		u.setDeptName("");
		u.setPosCode("");
		u.setPosName("");
		u.setUpdatedBy("");
		u.setCreatedBy("");
		u.setEntryDate("2014-01-01");
		u.setLeaveDate("2014-01-01");
		userDAO.insertAUser(u);
	}
	
	@Test
	public void updateUser() {
		User u = new User();
		u.setUserId("111");
		u.setUserName("222");
		LdapShaPasswordEncoder encoder = new LdapShaPasswordEncoder();
		u.setPassword(encoder.encodePassword("123456",
				String.valueOf(System.currentTimeMillis()).getBytes()));
		u.setEnabled("1");
		u.setMobilePhone("");
		u.setEmail("");
		u.setDeptCode("");
		u.setDeptName("");
		u.setPosCode("");
		u.setPosName("");
		u.setUpdatedBy("");
		u.setCreatedBy("");
		u.setEntryDate("2014-01-01");
		u.setLeaveDate("2014-01-01");
		userDAO.updateUser(u);
	}
	
	@Test
	public void pwdModefy() throws Exception{
		User u = new User();
		u.setUserId("444");
		u.setPassword("123456");
		u.setNewPassword("123");
		u.setUpdatedBy("444");
		System.out.println(userPojoServiceImpl.pwdModefy(u));
	}


}
