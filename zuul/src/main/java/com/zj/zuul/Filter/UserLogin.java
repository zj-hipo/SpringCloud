package com.zj.zuul.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.apache.commons.lang3.StringUtils;
import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;

/**
 * @program: SpringCloud0805
 * @description: 自定义过滤器;模拟登陆
 * @author: 张军
 * @create: 2020-08-13 21:34
 **/
@Component
public class UserLogin extends ZuulFilter{
    /*登陆拦截，前置
    * FilterConstants.PRE_TYPE相当于"pre"
    * */
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }
    /*顺序这只为1*/
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER-1;
    }
    /*返回true，代表过滤器生效*/
    public boolean shouldFilter() {
        return true;
    }
    /*业务逻辑
    * */
    public Object run() throws ZuulException {
        //获取请求参数 access
        //判断是否存在
        //不存在，未登录，则拦截
        //http://localhost:10086/news/28?access=123

        // 1）获取Zuul提供的请求上下文对象
        RequestContext ctx = RequestContext.getCurrentContext();
        // 2) 从上下文中获取request对象
        HttpServletRequest req = ctx.getRequest();
        // 3) 从请求中获取token
        String token = req.getParameter("access");
        //4)判断,用commons-lang3工具
        if (StringUtils.isBlank(token)) {
            ctx.setSendZuulResponse(false);
            //spring包下的状态码,返回403
            ctx.setResponseStatusCode(HttpStatus.FORBIDDEN.value());
        }
        return null;
    }
}
