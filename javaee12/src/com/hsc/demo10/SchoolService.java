package com.hsc.demo10;

/**
 * 学校服务管理系统
 */
public interface SchoolService {

    // 登录业务
    String login(String loginName, String passWord);

    // 得到所有班级
    String getAllClazzs();
}
