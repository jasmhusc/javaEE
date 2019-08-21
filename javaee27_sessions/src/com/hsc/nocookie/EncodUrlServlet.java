package com.hsc.nocookie;

import com.hsc.entity.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EncodUrlServlet", urlPatterns = "/EncodUrlServlet")
public class EncodUrlServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        /*
        1.服务器是通过sessionID来鉴别浏览器重启和不同浏览器的，以此分别每一次session;
        2.当客户端浏览器禁用cookie后，sessionID无法通过cookie发送给浏览器保存，浏览器没有该cookie；
        3.服务器的sessionID会保存在内存中，默认30分钟有效，不会马上消失，但由于每次会话浏览器都没有携带JSESSIONID的cookie，
        所以每次会话，服务器都认为是一次新的session，都会创建新的session。
        4.可以在跳转到其他servlet时，在url后面拼接上cookie:JSESSIONID=xxx，相当于模拟浏览器的cookie。
         */
        // 1.存储数据
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        session.setAttribute("student", new User("柳岩", "liuyan"));
        // 2.重定向到DecodUrlServlet
//        response.sendRedirect("DecodUrlServlet"); 不行
        /**
         * 机制：重写url方式会判断客户端浏览器是否支持 Cookie，如果支持 Cookie，直接返回参数 url；
         * 如果不支持 Cookie，就在参数 url 中加入 Session ID 信息，然后返回修改后的 url。
         */
        response.sendRedirect(response.encodeRedirectURL("DecodUrlServlet"));
    }
}
