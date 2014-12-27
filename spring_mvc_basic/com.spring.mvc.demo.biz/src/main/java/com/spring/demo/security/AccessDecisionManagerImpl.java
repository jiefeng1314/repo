package com.spring.demo.security;

import java.util.Collection;
import java.util.Iterator;

import org.apache.log4j.Logger;
import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.stereotype.Service;

import com.spring.demo.biz.dto.Authority;

/**
 * @author cissalc    liuxiangfei
 */
@Service("accessDecisionManager")
public class AccessDecisionManagerImpl implements AccessDecisionManager {

	/**
	 * Logger
	 */
	protected Logger logger = org.apache.log4j.Logger.getLogger(this.getClass()
			.getName());

	/**
     * 
     */
	static final Authority ADMINISTRATOR = new Authority("administrator");

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.AccessDecisionManager#decide(org.
	 * springframework.security.core.Authentication, java.lang.Object,
	 * java.util.Collection)
	 */
	
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (logger.isDebugEnabled()) {
			logger.debug("开始决策用户权限 ");
			logger.debug(object);
			logger.debug(authentication.getAuthorities());
			logger.debug(authentication.getName());
			logger.debug(authentication.getDetails());
		}
		if (configAttributes == null) {
			return;
		}
		/*
		 * if( authentication.getAuthorities().contains( ADMINISTRATOR)) { //
		 * 管理员可以访问所有页面. return; }
		 */
		logger.debug("可用的权限configAttributes");
		logger.debug(configAttributes);
		Iterator<ConfigAttribute> iterator = configAttributes.iterator();
		while (iterator.hasNext()) {
			ConfigAttribute configAttribute = iterator.next();
			String needPermission = configAttribute.getAttribute();
			for (GrantedAuthority ga : authentication.getAuthorities()) {
				if (needPermission.equalsIgnoreCase(ga.getAuthority())) {
					logger.info("决策用户权限成功");
					return;
				}
			}
		}
		logger.info("决策用户权限失败");
		// throw new AccessDeniedException( String.valueOf(
		// authentication.getAuthorities()));
		return;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.AccessDecisionManager#supports(org
	 * .springframework.security.access.ConfigAttribute)
	 */
	
	public boolean supports(ConfigAttribute attribute) {
		if (logger.isDebugEnabled()) {
			logger.debug(attribute.getClass());
		}
		return true;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.access.AccessDecisionManager#supports(java
	 * .lang.Class)
	 */
	
	public boolean supports(Class<?> clazz) {
		if (logger.isDebugEnabled()) {
			logger.debug(clazz);
		}
		return true;
	}

}
