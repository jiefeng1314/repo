package com.spring.demo.biz.service.impl;

import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.GrantedAuthorityImpl;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.spring.demo.biz.dto.Authority;
import com.spring.demo.biz.dto.User;
import com.spring.demo.biz.service.ServiceException;
import com.spring.demo.biz.service.UserService;

/**
 * @author cissalc    liuxiangfei
 */
@Service("userDetailsService")
public class UserDetailsPojoServiceImpl implements UserDetailsService {

	/**
	 * Logger
	 */
	protected Logger logger = org.apache.log4j.Logger.getLogger(this.getClass()
			.getName());

	/**
     * 
     */
	@Autowired
	UserService userPojoServiceImpl;

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.springframework.security.core.userdetails.UserDetailsService#
	 * loadUserByUsername(java.lang.String)
	 */
	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException, DataAccessException {
		try {
			User user = userPojoServiceImpl.getUser(username);
			if (user == null) {
				throw new UsernameNotFoundException(username);
			}
			List<Authority> authorities = new java.util.ArrayList<Authority>();
			return new UserDetailsImpl(user, authorities);
		} catch (ServiceException ex) {
			if (ex.getCause() instanceof DataAccessException) {
				throw (DataAccessException) ex.getCause();
			} else {
				throw new UsernameNotFoundException(ex.getMessage());
			}
		}
	}

	/**
	 * @author cissalc    liuxiangfei
	 */
	static class UserDetailsImpl implements UserDetails {

		/**
         * 
         */
		private static final long serialVersionUID = 1889887012449097747L;
		/**
         * 
         */
		private Collection<GrantedAuthority> authorities;

		/**
         * 
         */
		private User user;

		/**
		 * @param user
		 * @param roles
		 */
		public UserDetailsImpl(User user, List<Authority> roles) {
			this.user = user;
			authorities = new java.util.ArrayList<GrantedAuthority>();
			authorities.add(new GrantedAuthorityImpl("ROLE_USER"));
			authorities.add(new GrantedAuthorityImpl("AUTHENTICATED_USER"));
			for (Authority role : roles) {
				authorities.add(new GrantedAuthorityImpl(role.getAuthority()));
			}
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.springframework.security.core.userdetails.UserDetails#getAuthorities
		 * ()
		 */
		public Collection<GrantedAuthority> getAuthorities() {
			return authorities;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.springframework.security.core.userdetails.UserDetails#getPassword
		 * ()
		 */
		public String getPassword() {
			return user.getPassword();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.springframework.security.core.userdetails.UserDetails#getUsername
		 * ()
		 */
		public String getUsername() {
			return user.getUserId();
		}

		/**
		 * @return
		 */
		public String getFullName() {
			return user.getUserName();
		}

		/**
		 * 
		 * @return
		 */
		public User getUser() {
			return this.user;
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.security.core.userdetails.UserDetails#
		 * isAccountNonExpired()
		 */
		public boolean isAccountNonExpired() {
			return user.getIsEnabled();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.security.core.userdetails.UserDetails#
		 * isAccountNonLocked()
		 */
		public boolean isAccountNonLocked() {
			return user.getIsEnabled();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see org.springframework.security.core.userdetails.UserDetails#
		 * isCredentialsNonExpired()
		 */
		public boolean isCredentialsNonExpired() {
			return user.getIsEnabled();
		}

		/*
		 * (non-Javadoc)
		 * 
		 * @see
		 * org.springframework.security.core.userdetails.UserDetails#isEnabled()
		 */
		public boolean isEnabled() {
			return user.getIsEnabled();
		}

	}

}
