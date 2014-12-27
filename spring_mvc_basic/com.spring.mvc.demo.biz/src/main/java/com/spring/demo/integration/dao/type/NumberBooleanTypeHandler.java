package com.spring.demo.integration.dao.type;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.MappedJdbcTypes;
import org.apache.ibatis.type.TypeHandler;

/**
 * @author cissalc    liuxiangfei
 */
@MappedJdbcTypes(JdbcType.NUMERIC)
public class NumberBooleanTypeHandler implements TypeHandler<Boolean> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet,
	 * java.lang.String)
	 */
	
	public Boolean getResult(ResultSet rs, String name) throws SQLException {
		int v = rs.getInt(name);
		return v == 1 ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet,
	 * int)
	 */
	
	public Boolean getResult(ResultSet rs, int name) throws SQLException {
		int v = rs.getInt(name);
		return v == 1 ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.ibatis.type.TypeHandler#getResult(java.sql.CallableStatement,
	 * int)
	 */
	
	public Boolean getResult(CallableStatement arg0, int arg1)
			throws SQLException {
		int v = arg0.getInt(arg1);
		return v == 1 ? true : false;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.apache.ibatis.type.TypeHandler#setParameter(java.sql.PreparedStatement
	 * , int, java.lang.Object, org.apache.ibatis.type.JdbcType)
	 */
	
	public void setParameter(PreparedStatement ps, int arg1, Boolean arg2,
			JdbcType arg3) throws SQLException {
		ps.setInt(arg1, arg2 == true ? 1 : 0);
	}
}
