package com.hsc.proxy;

public class UserDaoImp implements UserDao {

    @Override
    public void delete() {

        System.out.println("删除成功！");
    }

    @Override
    public int apply(int i) {
        //System.out.println(i);
        return i * 2;
    }


}
