package com.hsc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/*
 * 路径的配置通过urlPatterns属性完成的，这个属性有2中写法
 * 方式1：拦截一个路径，urlPatterns = "/url"
 * 方式2：拦截多个路径，urlPatterns = {"/url1","/url2",...}
 * */
@WebFilter(filterName = "UrlFilter", urlPatterns = {
        // 精确匹配
        "/UrlFilter", "/index.html", "/admin/login.jsp",
        // 模糊匹配
        "/abc/*", "*.html"
})
public class UrlFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
