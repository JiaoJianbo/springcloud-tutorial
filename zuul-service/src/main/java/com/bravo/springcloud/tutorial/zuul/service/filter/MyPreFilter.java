package com.bravo.springcloud.tutorial.zuul.service.filter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

@Component
public class MyPreFilter extends ZuulFilter {
	private static Logger log = LoggerFactory.getLogger(MyPreFilter.class);

	/*
	 * run：过滤器的具体逻辑，这里只是将请求的URL简单些到日志中。
	 * 可以很复杂，包括查sql，nosql去判断该请求到底有没有权限访问。
	 */
	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		String s = String.format("%s >>> %s", request.getMethod(), request.getRequestURL().toString());
		log.info(s);
		return null;
	}

	/*
	 * shouldFilter：这里可以写逻辑判断，是否要过滤，本文true,永远过滤。
	 */
	@Override
	public boolean shouldFilter() {
//		RequestContext ctx = RequestContext.getCurrentContext();
//		return !ctx.containsKey(FORWARD_TO_KEY) // a filter has already forwarded
//				&& !ctx.containsKey(SERVICE_ID_KEY); // a filter has already determined serviceId
		return true;
	}

	/*
	 * filterOrder：过滤的顺序 
	 */
	@Override
	public int filterOrder() {
		//return PRE_DECORATION_FILTER_ORDER - 1; // run before PreDecoration
		return 0;
	}

	/*
	 * filterType：返回一个字符串代表过滤器的类型，在zuul中定义了四种不同生命周期的过滤器类型：
	 * pre：路由之前
	 * routing：路由之时
	 * post： 路由之后
	 * error：发送错误调用
	 */
	@Override
	public String filterType() {
		//return PRE_TYPE;
		return "pre";
	}

}
