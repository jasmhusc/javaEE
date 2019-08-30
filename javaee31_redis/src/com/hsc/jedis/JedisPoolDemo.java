package com.hsc.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.Set;

public class JedisPoolDemo {
    public static void main(String[] args) {

        // 1.创建连接池配置对象
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        // 连接池中的最大jedis链接数
        jedisPoolConfig.setMaxTotal(10);
        // 最长等待时间:单位（毫秒）
        jedisPoolConfig.setMaxWaitMillis(30000);

        // 2.创建链接池对象，设置：主机，端口，
        JedisPool jedisPool = new JedisPool(jedisPoolConfig, "localhost", 6379);
        Jedis jedis = jedisPool.getResource();

        // 3.jedis进行操作
        jedis.sadd("mySet", "china", "usa", "japan", "korean");

        // 获取数据
        Set<String> mySet = jedis.smembers("mySet");
        mySet.forEach(System.out::println);

        // 4.关闭链接，将链接放回连接池
        jedis.close();
        // 暂时关闭连接池，通常不关闭
        jedisPool.close();
    }
}
