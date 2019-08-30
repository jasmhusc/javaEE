package com.hsc.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.ResourceBundle;

/**
 * host，port，MaxTotal，MaxWaitMillis放在配置文件中，jedis.properties
 * ResourceBundle专门用于读取properties文件：只用写文件名，不用写后缀.properties
 * 工具类专门用于读取配置文件，创建连接池，获取链接对象
 */
public class JedisUtils {

    private static JedisPool pool;

    static {
        // 读取文件，获取连接池对象
        ResourceBundle resourceBundle = ResourceBundle.getBundle("jedis");
        String host = resourceBundle.getString("host");
        int port = Integer.parseInt(resourceBundle.getString("port"));
        int maxTotal = Integer.parseInt(resourceBundle.getString("MaxTotal"));
        int maxWaitMillis = Integer.parseInt(resourceBundle.getString("MaxWaitMillis"));

        // 创建配置对象
        JedisPoolConfig poolConfig = new JedisPoolConfig();
        poolConfig.setMaxTotal(maxTotal);
        poolConfig.setMaxWaitMillis(maxWaitMillis);

        // 创建连接池对象
        pool = new JedisPool(poolConfig, host, port);
    }

    // 获取jedis的接口api
    public static Jedis getJedis() {
        return pool.getResource();
    }
}
