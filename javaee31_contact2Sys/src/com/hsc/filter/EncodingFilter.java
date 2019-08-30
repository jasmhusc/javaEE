package com.hsc.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "EncodingFilter", urlPatterns = "/*")
public class EncodingFilter implements Filter {

    public void init(FilterConfig config) throws ServletException {

    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request = (HttpServletRequest) req;
        HttpServletResponse response = (HttpServletResponse) resp;

        String method = request.getMethod();
        // 如果提交数据为post，才有乱码
        if ("post".equalsIgnoreCase(method)) {
            request.setCharacterEncoding("utf8");
        }

        // 判断请求的数据类型，如果是css，js就不处理
        String uri = request.getRequestURI();
        if (uri.indexOf(".css") > 0 || uri.indexOf(".js") > 0 || uri.indexOf(".png") > 0) {
            chain.doFilter(request, response);
            return;
        }
        response.setContentType("text/html;charset=utf8");
        chain.doFilter(request, response);
    }

    public void destroy() {

    }
}
