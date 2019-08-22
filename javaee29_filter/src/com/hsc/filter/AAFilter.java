package com.hsc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1.当web.xml中配置了：/aa后，此处的/a与之重复了，web.xml的配置优先级更高，此处的失效。
 * 2.按照filterName字母排序，这里应该AAFilter先拦截，BBFilter再拦截；
 * 然而在web.xml配置后，结果与后者配置顺序一致；
 * 总结：filename和urlpattern都是以web.xml的配置优先。
 */
@WebFilter(filterName = "AAFilter", urlPatterns = "/ab")
public class AAFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        System.out.println("AAFilter拦截请求request");
        chain.doFilter(request, response);
        System.out.println("AAFilter拦截响应response");
    }

    public void destroy() {

    }
}
