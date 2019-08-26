package com.hsc.logincontrol;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "LoginControlFilter", urlPatterns = "/admin/*")
public class LoginControlFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 检查是否登录，控制admin下访问权限。
        if (request.getSession().getAttribute("loginuser") != null) {
            chain.doFilter(request, response);
        } else {
            response.sendRedirect(request.getContextPath() + "/login.jsp");
        }
    }

    public void destroy() {

    }
}
