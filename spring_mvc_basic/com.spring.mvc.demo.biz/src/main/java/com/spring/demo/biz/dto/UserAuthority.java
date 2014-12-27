package com.spring.demo.biz.dto;

import java.io.Serializable;

/**
 * @author cissalc    liuxiangfei
 */
public class UserAuthority implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID= 8579835820360726345L;

    /**
     * 登录账号
     */
    protected String userId;

    /**
     * 
     */
    protected String authority;

    /**
     * 
     */
    public UserAuthority() {

    }

    /**
     * @return the userId
     */
    public String getUserId() {
        return userId;
    }

    /**
     * @param userId
     *            the userId to set
     */
    public void setUserId( String userId) {
        this.userId= userId;
    }

    /**
     * @return the authority
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * @param authority
     *            the authority to set
     */
    public void setAuthority( String authority) {
        this.authority= authority;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#hashCode()
     */
    @Override
    public int hashCode() {
        final int prime= 31;
        int result= 1;
        result= prime * result + ((authority == null)?0 : authority.hashCode());
        result= prime * result + ((userId == null)?0 : userId.hashCode());
        return result;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#equals(java.lang.Object)
     */
    @Override
    public boolean equals( Object obj) {
        if( this == obj) return true;
        if( obj == null) return false;
        if( !(obj instanceof UserAuthority)) return false;
        UserAuthority other= (UserAuthority)obj;
        if( authority == null) {
            if( other.authority != null) return false;
        }else if( !authority.equals( other.authority)) return false;
        if( userId == null) {
            if( other.userId != null) return false;
        }else if( !userId.equals( other.userId)) return false;
        return true;
    }

    /*
     * (non-Javadoc)
     * @see java.lang.Object#toString()
     */
    @Override
    public String toString() {
        return "UserAuthority [userId=" + userId + ", authority=" + authority + "]";
    }

}
