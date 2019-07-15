package demo8;
/*
目标:研究枚举的底层

反编译工具
.java源代码 -> 编译javac -> .class字节码文件 -> java运行

.class字节码文件 -> 反编译工具 -> .java源代码

    枚举的本质是一个类. 是一个多例
    我们在枚举中定义的变量,最终会创建对象并赋值

    枚举本质是一个类,可以添加成员变量,成员方法

小结:
    枚举的本质是一个类,这个类只创建几个对象.(多例)
    枚举可以添加成员变量,构造方法,成员方法
*/
public class Demo8 {
    public static void main(String[] args) {
        WeekDay w = WeekDay.SUN;
        System.out.println(w.getNum());
    }
}
