package com.spring.demo.web.controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
/**
 *  author  liuxiangfei   cissalc
 *   2014年12月23日
 **/
public class BaseController {
	/**
	 * 获取当前用户id
	 * @return
	 */
	public String getCurrentUserId(){
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String currentUser = auth.getName();
		return currentUser;
	}
}
