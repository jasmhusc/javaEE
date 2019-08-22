package com.hsc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LifeCircleFilter", urlPatterns = "/LifeCircleFilter")
public class LifeCircleFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {
        // 初始化方法，filter創建的時候調用
        /*
         比servlet早创建，服务器启动时候创建;
          init方法只被调用一次，说明全局只创建一个过滤器对象，全局唯一，节省内存.
         */
        System.out.println("LifeCircleFilter创建了");
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 放行，在其前后进行request和response的拦截。
        chain.doFilter(request, response);
    }

    public void destroy() {

        // destroy销毁方法，当前服务器关闭之前调用
        System.out.println("LifeCircleFilter销毁了");
    }
}
