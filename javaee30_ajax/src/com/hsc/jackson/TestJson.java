package com.hsc.jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.hsc.entity.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TestJson {
    public static void main(String[] args) throws JsonProcessingException {

        // 测试json的映射，使用jackson的工具类
        //创建 ObjectMapper 对象
        ObjectMapper mapper = new ObjectMapper();

        //1.实例化 User 对象，给属性赋值
        User user = new User("张三", "24");
        //转成 JSON 对象
        String value = mapper.writeValueAsString(user);
        System.out.println(value);

        //2.创建数组
        String[] arr = {"张三", "李四", "王五"};
        System.out.println(mapper.writeValueAsString(arr));

        //3.创建一个集合，每个元素是一个 User 对象、
        List<User> users = new ArrayList<>();
        users.add(new User("张三", "24"));
        users.add(new User("张四", "25"));
        users.add(new User("张三疯", "20"));
        System.out.println(mapper.writeValueAsString(users));

        //4.Map 对象，键名为：user，键为 User 对象
        HashMap<String, Object> map = new HashMap<>();
        map.put("user", user);
        System.out.println(mapper.writeValueAsString(map));
    }
}
