package com.hsc.entity;

import com.alibaba.druid.pool.DruidDataSource;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

/**
 * 加载配置文件，这里包括：environment，mapper
 */
public class Configuration {
    /*
        driver,url,username,password可用于单元测试。
     */
    private String driver;
    private String url;
    private String username;
    private String password;
    // 创建德鲁伊连接池
    private DruidDataSource dds;
    // 创建一个map集合存储：方法名与mapper对象的键值对信息
    private HashMap<String, Mapper> mappers = new HashMap<>();

    // 无参构造初始化
    public Configuration() {
        // 加载核心配置文件，连接JDBC
        loadSqlMapConfig();
    }

    // 获取结果的接口：mappers
    public HashMap<String, Mapper> getMappers() {
        return mappers;
    }

    // 获取连接池的接口
    public DruidDataSource getDruidDataSource() {
        return dds;
    }

    private void loadSqlMapConfig() {

        // 1. 解析核心配置文件xml
        SAXReader reader = new SAXReader();
        InputStream is = Configuration.class.getResourceAsStream("/sqlMapConfig.xml");
        try {
            Document document = reader.read(is);
            // 2. 获取driver，url，username，password
            Element driverElement = (Element) document.selectSingleNode("//property[@name='driver']");
            driver = driverElement.attributeValue("value");
            Element urlElement = (Element) document.selectSingleNode("//property[@name='url']");
            url = urlElement.attributeValue("value");
            Element usernameElement = (Element) document.selectSingleNode("//property[@name='username']");
            username = usernameElement.attributeValue("value");
            Element passwordElement = (Element) document.selectSingleNode("//property[@name='password']");
            password = passwordElement.attributeValue("value");

            // 3. 根据environment配置创建Druid连接池
            dds = new DruidDataSource();
            dds.setDriverClassName(driver);
            dds.setUrl(url);
            dds.setUsername(username);
            dds.setPassword(password);

            // 4.解析接口配置文件
            List<Node> nodes = document.selectNodes("//mapper");
            for (Node node : nodes) {
                Element mapperElement = (Element) node;
                String resource = mapperElement.attributeValue("resource");
                // 5. 进一步解析MapperXml，信息封装进Mapper对象，存储在集合map中
                loadMapperXml(resource);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    private void loadMapperXml(String resource) throws DocumentException, IOException {
        /*
         每一个mapper的信息封装进Mapper对象，存储在集合map中；
         键：namespace+"."+id ，即类全名.方法名
         值：mapper对象
          */
        // 1. dom4j解析Mapper.Xml
        SAXReader reader = new SAXReader();
        InputStream in = Configuration.class.getResourceAsStream("/" + resource);
        Document document = reader.read(in);
        // 2. 获取namespace,id,resultType,sql语句
        Element rootElement = document.getRootElement();
        String namespace = rootElement.attributeValue("namespace");
        // 获取select元素的内容
        Element selectElement = rootElement.element("select");
        String id = selectElement.attributeValue("id");
        String resultType = selectElement.attributeValue("resultType");
        String sql = selectElement.getTextTrim();
        // 封装成Mapper对象，添加键值对。
        String name = namespace + "." + id;
        Mapper mapper = new Mapper(namespace, id, resultType, sql);
        mappers.put(name, mapper);
        // 关闭资源
        in.close();
    }

    @Override
    public String toString() {
        return "Configuration{" +
                "driver='" + driver + '\'' +
                ", url='" + url + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", dds=" + dds +
                ", mappers=" + mappers +
                '}';
    }
}
