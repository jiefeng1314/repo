package com.spring.demo.integration.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author cissalc    liuxiangfei
 * 
 */
public final class Utils {

	/**
	 * 
	 * @param conn
	 * @param ps
	 * @param rs
	 */
	public static void closeDB(Connection conn, Statement ps, ResultSet rs) {
		try {
			if (rs != null) {
				rs.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (ps != null) {
				ps.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
	}

}
