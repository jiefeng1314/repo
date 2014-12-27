package com.spring.demo.security;

import java.io.Serializable;
import java.util.Collection;

import org.apache.log4j.Logger;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.security.access.PermissionEvaluator;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

/**
 * @author cissalc    liuxiangfei
 */
@Service("permissionEvaluator")
public class PermissionEvaluatorImpl implements PermissionEvaluator {

    /**
     * Logger
     */
    protected Logger logger= org.apache.log4j.Logger.getLogger( this.getClass().getName());

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.security.access.PermissionEvaluator#hasPermission
     * (org.springframework.security.core.Authentication, java.lang.Object,
     * java.lang.Object)
     */
    
    public boolean hasPermission( Authentication authentication, Object targetDomainObject, Object permission) {
        logger.debug( "开始决策权限");
        DirectFieldAccessor acc= new DirectFieldAccessor( targetDomainObject);
        Object value= permission + "_" + acc.getPropertyValue( String.valueOf( permission));
        @SuppressWarnings("rawtypes")
        Collection authorities= authentication.getAuthorities();
        if( authorities.contains( value)) {
            logger.debug( "决策权限结果为true");
            return true;
        }
        logger.debug( "决策权限结果为false");
        return false;
    }

    /*
     * (non-Javadoc)
     * @see
     * org.springframework.security.access.PermissionEvaluator#hasPermission
     * (org.springframework.security.core.Authentication, java.io.Serializable,
     * java.lang.String, java.lang.Object)
     */
    
    public boolean hasPermission(
            Authentication authentication, Serializable targetId, String targetType, Object permission) {
        // not supports.
        return false;
    }

}
