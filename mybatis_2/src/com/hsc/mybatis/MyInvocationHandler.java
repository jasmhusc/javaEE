package com.hsc.mybatis;

import com.alibaba.druid.pool.DruidDataSource;
import com.hsc.entity.Configuration;
import com.hsc.entity.Mapper;
import com.hsc.entity.User;
import com.hsc.utils.SourceCloseUtils;

import javax.sql.DataSource;
import java.lang.reflect.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * 伪装测试
 * ArrayList<User> list = new ArrayList<>();
 * list.add(new User(1, "渣渣辉", new Date(1000), "男", "铜锣湾"));
 * list.add(new User(2, "古校长", new Date(1000), "男", "尖沙咀"));
 * list.add(new User(3, "成龙", new Date(1000), "男", "太平山"));
 * list.add(new User(4, "陈小春", new Date(1000), "男", "九龙"));
 */
public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        /*
         1. 通过method获取该正在执行的方法所在类的信息
            Class<?> getDeclaringClass​()
            这里获取类全名。
          */
        String className = method.getDeclaringClass().getName();
        // 2. 拼接成：类全名.方法名字符串
        String key = className + "." + method.getName();
        /**
         * 创建configuration类，解析配置文件：
         * 1. 加载环境，获取连接。
         * 2. 得到类名.方法名--mapper对象的map集合
         * 3. mapper下写的是Mapper.xml，需要进一步解析。
         * 4. 创建Mapper对象存储每一个mapper的信息
         */
        // 3. 得到结果：实际是sql与方法的对应关系映射
        Configuration configuration = new Configuration();
        HashMap<String, Mapper> mappers = configuration.getMappers();
        DruidDataSource dds = configuration.getDruidDataSource();
        // 4. 在集合中寻找该方法名对应的sql语句
        Mapper mapper = mappers.get(key);
        ArrayList list = mapperToUsers(dds, mapper);

        return list;
    }

    private ArrayList mapperToUsers(DataSource ds, Mapper mapper) throws Exception {
        // 1. 根据映射的类型获得其Class对象
        String userCls = mapper.getResultType();
        Class<?> aClass = Class.forName(userCls);

        // 2. 获取连接connection和statement，执行sql语句
        Connection conn = ds.getConnection();
        String sql = mapper.getSql();
        PreparedStatement ps = conn.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        ResultSetMetaData metaData = rs.getMetaData();

        // 3. 遍历结果，映射成User对象
        ArrayList list = new ArrayList();
        while (rs.next()) {
            // 4. 获取实例对象
            Constructor<?> constructor = aClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            User user = (User) constructor.newInstance();

            // 5. 设置User对象的值
            int count = metaData.getColumnCount();
            for (int i = 1; i <= count; i++) {
                String columnName = metaData.getColumnName(i);
                Object value = rs.getObject(columnName);

                // 6. 反射获取字段，设置字段值
                Field field = aClass.getDeclaredField(columnName);
                field.setAccessible(true);
                field.set(user, value);
            }

            // 7. 添加到集合
            list.add(user);
        }

        // 8. 关闭资源
        SourceCloseUtils.close(conn, ps, rs);

        return list;
    }
}
