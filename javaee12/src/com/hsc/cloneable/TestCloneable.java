package com.hsc.cloneable;

/*
 *   原型模式
 */
public class TestCloneable {

    public static void main(String[] args) throws Exception {

        System.out.println("-------------------我的简历--------------------");
        Resume MyResume = new Resume();
        PhoneNum phoneNum = new PhoneNum("13772589965");
        MyResume.setInfo("周星驰", 23, phoneNum);
        MyResume.setWork("华谊兄弟", "中国香港");
        MyResume.show();

        System.out.println("-------------------浅克隆--------------------");
        Resume clone1 = (Resume) MyResume.clone();   // 强转
        PhoneNum phone1 = clone1.getPhone();
        phone1.setPhone("123123");
        clone1.setInfo("刘德华", 30, phone1);  // 基础类型数据拷贝，引用型数据依然用原来的引用。
        clone1.show();
        MyResume.show();  // 引用类型数据随之改变

        System.out.println("-------------------深克隆--------------------");
        Resume clone2 = (Resume) MyResume.deepClone();   // 强转
        PhoneNum phone2 = clone2.getPhone();
        phone2.setPhone("456789");
        clone2.setInfo("朱茵", 21, phone2);
        clone2.show();
        MyResume.show();   // 引用类型数据不会改变
    }

}
