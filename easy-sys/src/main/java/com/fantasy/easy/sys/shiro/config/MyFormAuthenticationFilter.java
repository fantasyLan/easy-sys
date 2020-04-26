/**
 * Snippet.java
 * @author Fantasy Lan
 */
package com.fantasy.easy.sys.shiro.config;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.http.HttpStatus;

/**
 * @author Fantasy Lan
 * @since 2019年12月8日 : 下午5:19:49 拦截登录成功的时候的跳转方法
 */
public class MyFormAuthenticationFilter extends FormAuthenticationFilter {

	@Override
	protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request,
			ServletResponse response) throws Exception {

		// String successUrl = "/admin/access/index.html";// 我是直接写死了跳转链接

		// WebUtils.issueRedirect(request, response, successUrl);
		// 这里不做处理，返回到真正处理登录成功的页面
		return true;// 返回false表示执行链结束

	}
	

	@Override
	protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
		if (isLoginRequest(request, response)) {
			return super.onAccessDenied(request, response);
		} else {
			if (isAjax((HttpServletRequest) request)) {
				HttpServletResponse httpServletResponse = WebUtils.toHttp(response);
				httpServletResponse.addHeader("REQUIRE_AUTH", "true");
				httpServletResponse.setStatus(HttpStatus.UNAUTHORIZED.value());
			} else {
				saveRequestAndRedirectToLogin(request, response);
			}
			return false;
		}
	}

	/**
	 * 前后端分离 全部都是ajax
	 */
	private boolean isAjax(HttpServletRequest request) {
		// String requestedWithHeader = request.getHeader("X-Requested-With");
		// return "XMLHttpRequest".equals(requestedWithHeader);
		return true;
	}

}
