package com.spring.demo.integration.dao.impl;

import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author cissalc    liuxiangfei
 */
public class MyBatisBaseDAO extends SqlSessionDaoSupport {

	/**
     * 
     */
	@Autowired
	public void setSqlSessionTemplate(SqlSessionTemplate sqlSessionTemplate) {
		super.setSqlSessionTemplate(sqlSessionTemplate);
	}

	/**
     * 
     */
	public MyBatisBaseDAO() {
	}

}
