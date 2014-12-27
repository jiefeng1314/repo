package com.spring.demo.security;

import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import org.springframework.security.authentication.encoding.LdapShaPasswordEncoder;
import org.springframework.security.authentication.encoding.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 * @author cissalc    liuxiangfei
 */
@Service("passwordEncoder")
public class UserPasswordEncoderImpl implements PasswordEncoder {

	/**
     * 
     */
	protected Logger logger = org.apache.log4j.Logger.getLogger(this.getClass()
			.getName());

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.authentication.encoding.PasswordEncoder#
	 * encodePassword(java.lang.String, java.lang.Object)
	 */
	
	public String encodePassword(String rawPass, Object salt)
			throws DataAccessException {
		if (logger.isDebugEnabled()) {
			logger.debug("salt:" + salt);
		}
		LdapShaPasswordEncoder encoder = new LdapShaPasswordEncoder();
		String encodePwd = encoder.encodePassword(rawPass, salt);
		if (logger.isDebugEnabled()) {
			logger.debug("encodePwd:" + encodePwd);
		}
		return encodePwd;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.springframework.security.authentication.encoding.PasswordEncoder#
	 * isPasswordValid(java.lang.String, java.lang.String, java.lang.Object)
	 */
	
	public boolean isPasswordValid(String encPass, String rawPass, Object salt)
			throws DataAccessException {
		if (logger.isDebugEnabled()) {
			logger.debug("encPass:" + encPass);
			logger.debug("rawPass:" + rawPass);
			logger.debug("salt:" + salt);
		}
		LdapShaPasswordEncoder encoder = new LdapShaPasswordEncoder();
		return encoder.isPasswordValid(encPass, rawPass, salt);
	}

}
