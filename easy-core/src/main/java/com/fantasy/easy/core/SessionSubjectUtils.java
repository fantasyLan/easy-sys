/**
 * SessionSubjectUtils.java
 * @author Fantasy Lan
 */
package com.fantasy.easy.core;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.subject.Subject;

import com.fantasy.easy.core.vo.GlobalAttributes;

/**
 * @author Fantasy Lan
 * @since 2019年12月5日 : 上午12:11:25
 */
public class SessionSubjectUtils {

	private static ThreadLocal<GlobalAttributes> local = new ThreadLocal<GlobalAttributes>();
	
	public static Subject getSubject() {
		return SecurityUtils.getSubject();
	}
	
	public static String getToken() {
		return getSubject().getSession().getId().toString();
	}
	
	public static void setIsException(boolean isException) {
		getLocal().setException(isException);
	}
	
	public static boolean isException() {
		return getLocal().isException();
	}
	
	private static GlobalAttributes getLocal(){
		GlobalAttributes l = local.get();
		if(l == null) {
			l = new GlobalAttributes();
			local.set(l);
		}
		return l;
	}
}
