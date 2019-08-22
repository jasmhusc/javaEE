package com.hsc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "DispatcherFilter", urlPatterns = "/EncodingServlet",
        /*配置拦截方式，拦截直接url访问和间接url访问（转发）
        * 默认REQUEST，如果要包含请求转发的拦截，加上FORWARD,也是数组
        * */
        dispatcherTypes = {DispatcherType.REQUEST, DispatcherType.FORWARD}
)
public class DispatcherFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 拦截request
        System.out.println("DispatcherFilter拦截request");
        chain.doFilter(request, response);
        System.out.println("DispatcherFilter拦截response");
    }

    public void destroy() {

    }
}
