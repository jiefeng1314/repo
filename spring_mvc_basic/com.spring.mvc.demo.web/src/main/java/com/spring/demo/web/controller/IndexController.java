package com.spring.demo.web.controller;

import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 *  author  liuxiangfei   cissalc
 *   2014年12月23日
 **/
@Controller
public class IndexController extends BaseController{
	private Logger logger = org.apache.log4j.Logger.getLogger(this.getClass().getName());

	@Value("${logon_url}")
	protected String logon_url;
	
	@RequestMapping(value = "/login")
	public ModelAndView login(){
		logger.debug("进入登录页面");
		return new ModelAndView("login");
	}
	
	@RequestMapping(value = "/index")
	public ModelAndView index() {
		logger.debug("进入首页");
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("userId", getCurrentUserId());
		return new ModelAndView("index", model);
	}
}
