package com.hsc.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsc.dao.IContact2;
import com.hsc.entity.Contact2;
import com.hsc.util.JedisUtils;
import com.hsc.util.MybatisUtils;
import org.apache.ibatis.session.SqlSession;
import redis.clients.jedis.Jedis;

import java.util.List;

public class Contact2Service {

    // 先从redis获取数据，如果是第一次就从mysql获取
    public String findAllContacts() throws JsonProcessingException {

        // 直接从redis获取数据
        Jedis jedis = JedisUtils.getJedis();
        String contactsList = jedis.get("contactsList");

        // 判断是否为空
        if (contactsList == null) {
            // 1.从mysql获取
            SqlSession sqlSession = MybatisUtils.getSession();
            IContact2 contact2Dao = sqlSession.getMapper(IContact2.class);
            List<Contact2> contact2s = contact2Dao.findAll();
            // 2.将数据转成json字符串
            ObjectMapper objectMapper = new ObjectMapper();
            contactsList = objectMapper.writeValueAsString(contact2s);
            // 3.将json字符串写入redis
            jedis.set("contactsList", contactsList);
        }
        return contactsList;
    }
}
