package com.hsc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/EncodingServlet")
public class EncodingFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;
        // 解决乱码
        if ("post".equals(request.getMethod())) {
            request.setCharacterEncoding("UTF-8");
        }
        response.setContentType("text/html;charset=UTF-8");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}
