package com.hsc.proxy;

public class UserDaoImp implements UserDao {

    @Override
    public void delete() {

        System.out.println("ɾ�����ݣ�");
    }

    @Override
    public int apply(int i) {
        //System.out.println(i);
        return i * 2;
    }


}
