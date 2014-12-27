package com.spring.demo.integration.dao;

import org.apache.ibatis.io.Resources;
import org.apache.log4j.Logger;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

/**
 * @author cissalc    liuxiangfei
 */
public class SqlSessionFactoryBean extends
		org.mybatis.spring.SqlSessionFactoryBean implements
		ApplicationContextAware {

	/**
	 * Logger
	 */
	protected Logger logger = org.apache.log4j.Logger.getLogger(this.getClass()
			.getName());

	/**
     * 
     */
	ApplicationContext applicationContext;

	/**
     * 
     */
	public SqlSessionFactoryBean() {

	}

	/**
     * 
     */
	public void setClassLoader() {
		logger.info("为MyBatis设置ClassLoader。");
		Resources.setDefaultClassLoader(getParentClassLoader(applicationContext));
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.context.ApplicationContextAware#setApplicationContext
	 * (org.springframework.context.ApplicationContext)
	 */
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}

	/**
	 * @param appContext
	 * @return
	 */
	ClassLoader getParentClassLoader(ApplicationContext appContext) {
		ApplicationContext parent = appContext.getParent();
		if (parent == null) {
			return new ClassLoader(appContext.getClassLoader()) {
			};
		} else {
			return new ClassLoader(getParentClassLoader(parent)) {
			};
		}
	}
}
