package com.hsc.filter;

import com.hsc.entity.User;
import com.hsc.service.UserService;
import com.hsc.util.CookieUtils;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "AutologinFilter", urlPatterns = "/index.jsp")
public class AutologinFilter implements Filter {

    private UserService service = new UserService();

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        // 1.判断session，即是否已经登录
        User user = (User) request.getSession().getAttribute("user");
        if (user != null) {
            chain.doFilter(request, response);
        } else {
            // 2.判断cookie，执行自动登录
            Cookie[] cookies = request.getCookies();
            Cookie cookie = CookieUtils.findCookie(cookies, "auto_login");
            // 第一次登录没有cookie，或者cookie有效期已过。
            if (cookie == null) {
                chain.doFilter(request, response);
            } else {
                // 解析
                String value = cookie.getValue();
                String username = value.split("#")[0];
                String password = value.split("#")[1];
                // 存储进session
                User login = service.login(username, password);
                request.getSession().setAttribute("user", login);
                chain.doFilter(request, response);
            }
        }
    }

    public void destroy() {

    }
}
