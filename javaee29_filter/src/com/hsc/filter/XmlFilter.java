package com.hsc.filter;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 1.web.xml中也可以配置filter，格式如同servlet的配置，内部也可以配置initParameter参数；
 * 2.web.xml中的filter按照mapping的配置顺序依次执行过滤器；
 * 3.注解中的filter按照名字自然排序，tomcat服务器上，优先级只参考filer名字的第一个字母在字母表的顺序，
 * 靠前的优先级高，不区分大小写，串行过滤；
 */
public class XmlFilter implements Filter {

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
