package com.zhouheng.comservlet3.compont.filter;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author zhouheng
 * @Description:
 * @create 2019-01-31 15:03
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        System.out.println("通过过滤器的放行");
        chain.doFilter(request,response);

    }

    @Override
    public void destroy() {
        System.out.println("过滤器被销毁");
    }
}
