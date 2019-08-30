package com.hsc.util;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

public class JedisUtils {
    // 连接池对象
    private static JedisPool jedisPool;

    // 静态代码块加载配置文件，获取redis数据库连接
    static {
        // 1.ResourceBundle读取jedis.properties
        ResourceBundle bundle = ResourceBundle.getBundle("jedis");
        String host = bundle.getString("host");
        int port = Integer.parseInt(bundle.getString("port"));
        int maxTotal = Integer.parseInt(bundle.getString("maxTotal"));
        int maxWaitMillis = Integer.parseInt(bundle.getString("maxWaitMillis"));

        // 2.配置对象jedisPoolConfig
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxWaitMillis(maxWaitMillis);

        // 3.获取连接池对象
        jedisPool = new JedisPool(poolConfig, host, port);
    }

    // api
    public static Jedis getJedis() {
        return jedisPool.getResource();
    }
}
