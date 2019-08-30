package com.hsc.jedis;

import redis.clients.jedis.Jedis;

import java.util.Set;

public class JedisUtilsTest {
    public static void main(String[] args) {

        // 测试连接池
        Jedis jedis = JedisUtils.getJedis();

        // 添加数据
        jedis.zadd("myZset", 7, "奥多姆");
        jedis.zadd("myZset", 16, "加索尔");
        jedis.zadd("myZset", 8, "科比");

        // 获取数据
        Set<String> myZset = jedis.zrange("myZset", 0, -1);
        myZset.forEach(System.out::println);
    }
}
