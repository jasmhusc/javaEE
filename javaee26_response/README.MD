### response响应

#### ServletContext

- ServletContext:
    1. 一个上下文对象，每个 Web 应用程序都对应了一个上下文对象。
    2. 用于 Servlet 与容器（服务器）之间进行通讯，可以通过这个对象得到与 Web 容器(服务器)相关信息。
    3. ServletContext实例是通过 getServletContext()方法获得的。

- 作用：
    1. 可以用于读取项目内的资源文件
    2. 可以读取web.xml中全局配置参数
    3. 它是一个全局共享域对象，所有动态资源（servlet）都可以操作ServletContext内存读写数据
    
- 路径问题：
```
1. ServletContext.getResource(""): 默认目录为项目资源目录
    url = file:/F:/idea/javaEE/out/artifacts/javaee26_response_war_exploded/

2. ServletContext.getRealPath(""): 项目真实路径
    realPath = F:\idea\javaEE\out\artifacts\javaee26_response_war_exploded\
    
3. ServletContext3.class.getResource(""): 类路径，直接到当前类的包下
    url1 = file:/F:/idea/javaEE/out/artifacts/javaee26_response_war_exploded/
    WEB-INF/classes/com/hsc/servletcontext/    
    
4. this.getClass().getClassLoader().getResource(""): 类加载器路径
    url2 = file:/F:/idea/javaEE/out/artifacts/javaee26_response_war_exploded/
    WEB-INF/classes/    
```     
- WEB-INF包含
    1. classes：src下的java代码编译的.class文件;
    2. lib:  开发时放在WEB_INF下的lib文件，即引入的jar包。
    
- 加载web下资源：img/1.jpg
1. ServletContext.getRealPath("/img/1.jpg");
2. ServletContext.getResourceAsStream("/img/1.jpg");
3. this.getClass().getClassLoader().getResourceAsStream("../../img/1.jpg");

- 注意：
    1. web项目的类路径：
        HttpServlet.class.getResource(""): 是artifacts下classes的类路径
        file:/F:/idea/javaEE/out/artifacts/
            javaee26_response_war_exploded/WEB-INF/classes/com/hsc/servletcontext/  
   
    2. 普通项目的类路径：
        ClassPath.class.getResource(""): 是product下的类路径
        url = file:/F:/idea/javaEE/out/production/
            javaee26_response/com/hsc/servletcontext/
    
    3. src下的文件会随着java代码一起编译到WEB-INF/classes目录下，也会部署。
    
    4. Servlet里加载src下的文件（3），直接使用类相对路径：
        Demo.class.getResourceAsStream("/jdbc.propertes")  //第一个/代表src目录WEB-INF/classes

#### 响应行

1. 组成：http协议版本 状态码（200） 状态码描述（ok)
2. 302: 重定向，单独使用没有任何效果和含义
3. 404：访问的url写错了（几率最大）or 服务器没有这个资源
4. 405：访问一个Servlet没有doGet，doPost处理请求方法会报405错误
5. 500: 访问一个Servlet处理请求会抛出异常，查看浏览器会报500错误
```
response.sendError(404);
response.sendError(405);
response.setStatus(302);
```

#### 响应头
响应头：全部是键值对，给浏览器的命令：
```
Location:http://www.hsc.com  设置重定向要转的地址
server:apache tomcat 访问的服务器名字
Content-Encoding:gzip 服务器数据压缩格式，浏览器会进行解压
Content-Length；80 响应的长度
Content-Type:text/html;charset=utf-8 服务器发送过来的数据类型和字符集
Refresh:3;url=day30/hello.html 3秒后跳转到制定页面
Content-Disposition:attachment;filename=newbody.zip 以附件方式下载文件
```
-  void setHeader(String name, String value)  
    用给定名称和值设置响应头
    
- 解决中文名乱码
```
 //目标：读取一个资源文件图片输出给浏览器，浏览器采用附件下载【文件名为中文】

        //判断不同浏览器版本对中文文件名进行url编码操作
        String fileName="美女.jpg";
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

        //设置响应头content-disposition让浏览器附件下载,浏览器下载的文件名字为美女.jpg
        response.setHeader("content-disposition","attachment;filename="+fileName);
``` 
   