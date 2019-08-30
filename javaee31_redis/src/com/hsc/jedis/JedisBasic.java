package com.hsc.jedis;

import redis.clients.jedis.Jedis;

import java.util.List;
import java.util.Map;

public class JedisBasic {
    public static void main(String[] args) {

        // 1.创建jedis链接对象，指定主机名和端口号：localhost,6379
        Jedis jedis = new Jedis("localhost", 6379);

        // 2.添加数据
        // a.普通字符串
        jedis.set("person", "张三");
        // b.hash数据
        jedis.hset("m9", "cpu", "高通骁龙845");
        jedis.hset("m9", "price", "3399￥");
        // c.list类型
        jedis.lpush("cities", "珠海", "深圳", "广州");

        // 3.获取数据，输出数据
        // get
        String person = jedis.get("person");
        System.out.println("person = " + person);
        // hash的hgetall
        Map<String, String> m9 = jedis.hgetAll("m9");
        System.out.println("m9 = " + m9);
        // list的lrange
        List<String> cities = jedis.lrange("cities", 0, -1);
        System.out.println("cities = " + cities);

        // 4.关闭链接
        jedis.close();
    }
}
