package com.spring.demo.integration.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.spring.demo.biz.dto.User;
import com.spring.demo.integration.dao.UserDAO;

/**
 * @author cissalc    liuxiangfei
 * 
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:biz-context.xml" })
public class UserMybatisDAOImplTest {

	/**
	 * 
	 */
	@Autowired
	private UserDAO userDAO;

	/**
	 * 测试库数据源
	 */
	@Autowired
	DataSource dataSource;

	/**
	 * 
	 * @return
	 */
	protected User getTestUser3() {
		User u = new User();
		u.setUserId("LIUXIANGFEI_789789");
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
		u.setUserId("LIUXIANGFEI_456456");
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
		u.setUserId("LIUXIANGFEI_123123");
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
	protected void cleanUsers() {
		// clean test data
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn
					.prepareStatement("delete from T_USER where user_id in (?, ?, ?) ");
			ps.setString(1, getTestUser1().getUserId());
			ps.setString(2, getTestUser2().getUserId());
			ps.setString(3, getTestUser3().getUserId());
			ps.executeUpdate();
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			Utils.closeDB(conn, ps, rs);
		}
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

	/**
	 * Test method for
	 * {@link com.spring.demo.integration.dao.impl.UserMybatisDAOImpl#queryUser(java.lang.String)}
	 * .
	 */
	@Test
	public void testQueryUser() {
		//
		userDAO.insertAUser(getTestUser1());
		assertTrue(true);
		// assertion
		User u = userDAO.queryUser(getTestUser1().getUserId());
		assertNotNull(u);
		assertEquals(u.getUserId(), getTestUser1().getUserId());

		// clean test data
		cleanUsers();
	}

	/**
	 * Test method for
	 * {@link com.spring.demo.integration.dao.impl.UserMybatisDAOImpl#insertAUser(com.spring.demo.biz.dto.User)}
	 * .
	 */
	@Test
	public void testInsertAUser() {
		User u = getTestUser1();
		//
		userDAO.insertAUser(u);
		assertTrue(true);
		// assertion
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		try {
			conn = dataSource.getConnection();
			ps = conn.prepareStatement("select " + "user_id, " + "user_name, "
					+ "password, " + "enabled, " + "dept_code, "
					+ "dept_name, " + "pos_code, " + "pos_name, "
					+ "mobile_phone, " + "email from t_user "
					+ "where user_id=?");
			ps.setString(1, u.getUserId());
			rs = ps.executeQuery();
			assertTrue(rs.next());
			assertEquals(rs.getString("user_id"), u.getUserId());
			assertEquals(rs.getString("user_name"), u.getUserName());
			assertEquals(rs.getString("password"), u.getPassword());
			assertEquals(rs.getString("dept_code"), u.getDeptCode());
			assertEquals(rs.getString("dept_name"), u.getDeptName());
			assertEquals(rs.getString("pos_code"), u.getPosCode());
			assertEquals(rs.getString("pos_name"), u.getPosName());
			assertEquals(rs.getString("mobile_phone"), u.getMobilePhone());
			assertEquals(rs.getString("email"), u.getEmail());

		} catch (Exception ex) {
			ex.printStackTrace();
			fail(ex.getMessage());
		} finally {
			Utils.closeDB(conn, ps, rs);
		}

		// clean test data
		cleanUsers();

	}

	/**
	 * Test method for
	 * {@link com.spring.demo.integration.dao.impl.UserMybatisDAOImpl#queryAllUserList()}
	 * .
	 */
	@Test
	public void testQueryAllUserList() {
		try {
			//
			userDAO.insertAUser(getTestUser1());
			userDAO.insertAUser(getTestUser2());
			userDAO.insertAUser(getTestUser3());

			assertTrue(true);
			// assertion
			List<User> allUserList = userDAO.queryAllUserList();
			assertNotNull(allUserList);
//			assertTrue(allUserList.size() == 3);

			assertTrue(allUserList.contains(getTestUser1()));
			assertTrue(allUserList.contains(getTestUser2()));
			assertTrue(allUserList.contains(getTestUser3()));
		} finally {
			// clean test data
			cleanUsers();
		}
	}

}
