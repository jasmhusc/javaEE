### Request

#### HTTP协议 
http协议：规范了浏览器与服务器传输的请求与响应数据格式
http特性：无状态，http协议是无状态，无状态代表http协议不会存储传输数据，只是规定传输数据的格式。

#### HTTP请求
1. HTTP请求：用于封装浏览器发送给服务器的所有数据，称为请求（request）对象。
2. 继承关系：父接口ServletRequest -> 子接口HttpServletRequest -> 实现类HttpServletWrapper
3. request对象：当浏览器提交请求数据给到服务器，服务器会创建一个对象接收所有请求数据，这个对象就是request。

#### idea快捷键
1. 使用快捷键Ctrl+N,搜索HttpServletRequest,进入这个类
2. 使用快捷键Ctrl+F12，查看当前类内部所有成员
3. 使用快捷键Ctrl+H, 查看当前类的实现或子类
4. 使用快捷键Ctrl+Alt+U，查看当前类的继承实现接口的结构

#### Request的作用
1. 获取所有的请求数据（请求行，请求头，请求体）
2. request可以进行请求转发的页面跳转
3. request是一个作用域对象（请求域），可以操作服务器的内存数据，局限于一个请求内。

#### 获取请求行
```
getMethod(): Get/Post
getProtocol(): 协议http1.1
getContextpath(): 当前资源部署目录的名字
```

#### 获取请求头
```
getHeader(): 获取一个值
getHeaderNames(): 获取所有键值对
```
referer:浏览器上一个页面地址，从哪里来？
if-modified-since: 
    1. status:200从服务器读取
    2. status:304从本地缓存读取
    
#### 获取请求体
1. request.getParameter(String name) 根据请求参数数据的name获取对应的一个Sting类型的value
2. request.getParameterValues(String name) 根据请求参数数据的name获取一组String[]的数据
3. request.getParameterMap() 获取所有请求参数数据的键值对返回一个Map<String,String[]>
4. 中文乱码：request.setCharacterEncoding("utf-8").

#### BeanUtils
1. 如果客户端提交大量数据，服务器端一个一个获取是非常麻烦,
    需要使用工具类实现自动封装数据，第三方工具BeanUtils
2. BeanUtils 是 Apache commons组件的成员之一，主要用于简化JavaBean封装数据的操作。
    它可以将一个表单提交的所有数据封装到JavaBean中。
3. BeanUtils.populate(封装的对象,Map<String,Object>)    