package com.zj.zuul.Filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.exception.ZuulException;

/**
 * @program: SpringCloud0805
 * @description: ZuulFilter
 * @author: 张军
 * @create: 2020-08-13 21:18
 **/

public class UserFilter extends ZuulFilter {
    /*过滤器类型*/
    public String filterType() {
        return null;
    }

    /*过滤器顺序*/
    public int filterOrder() {
        return 0;
    }

    /*要不要过滤*/
    public boolean shouldFilter() {
        return false;
    }

    /*过滤逻辑*/
    public Object run() throws ZuulException {
        return null;
    }
}
