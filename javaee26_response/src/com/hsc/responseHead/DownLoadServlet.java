package com.hsc.responseHead;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Base64;

@WebServlet(name = "DownLoadServlet", urlPatterns = "/download")
public class DownLoadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // html页面有多个超链接，href="download?fileName=xx.yy"
        /*
        1. 即会访问项目下的download的servlet，本servlet改名：urlPatterns = "/download"
        2. 会传递数据：fileName = xx.yy
        3. 这里需要解决中文文件名的可能问题，并让对方以附件形式下载对应的文件。
        4. 这里html和项目下文件的名称是一样的，可以直接获取输入流。
         */
        // 1. url编码前先根据文件名得到本地文件的输入流
        String fileName = request.getParameter("fileName");
        InputStream inputStream = getServletContext().getResourceAsStream("/download/" + fileName);
        ServletOutputStream outputStream = response.getOutputStream();
        // 2. url编码
        fileName = getUrlEncodingFileName(request, fileName);
        // 3. 设置以附件形式下载
        response.setHeader("Content-Disposition", "attachment;fileName=" + fileName);
        // 4. IO工具类读写操作
        IOUtils.copy(inputStream, outputStream);
        inputStream.close();
    }

    private String getUrlEncodingFileName(HttpServletRequest request, String fileName) throws UnsupportedEncodingException {
        //判断不同浏览器版本对中文文件名进行url编码操作
        String ua = request.getHeader("User-Agent");
        boolean IE_LT11 = ua.contains("MSIE"); // IE11以下版本
        boolean IE11 = ua.contains("rv:11.0) like Gecko"); // IE11
        boolean Edge = ua.contains("Edge"); // win10自带的Edge浏览器
        // 如果是微软的浏览器，直接进行UTF-8编码
        if (IE_LT11 || IE11 || Edge) {
            fileName = URLEncoder.encode(fileName, "UTF-8");
            //由于编码数据给到浏览器，浏览器会自动url解码，所以jav编码的数据必须浏览器可以识别
            // java的编码方式和浏览器有略微的不同：对于空格，java编码后的结果是加号，
            // 而浏览器的编码结果是%20，因此将+替换成%20, 这样浏览器才能正确解析空格
            fileName = fileName.replace("+", "%20");
        }
        // 标准浏览器使用Base64编码
        else {
            Base64.Encoder encoder = Base64.getEncoder();
            fileName = encoder.encodeToString(fileName.getBytes("utf-8"));
            // =?utf-8?B?文件名?= 是告诉浏览器以Base64进行解码
            fileName = "=?utf-8?B?" + fileName + "?=";
        }
        return fileName;
    }
}
