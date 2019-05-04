package com.zhouheng.myspringmvc.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * 描述:
 *
 * @author zhouheng
 * @create 2019-04-22 下午 10:09
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        chain.doFilter(request,response);
    }

    @Override
    public void destroy() {

    }
}
