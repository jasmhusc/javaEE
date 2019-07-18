package demo7;

/*
ctrl + f12看类里面的成员变量和成员方法

Object类:
       1.   public native int hashCode(); 返回对象的哈希码值。
            native: 本地，表示调用系统资源
            对象的hashCode相当于人的身份证
            默认情况对象的hashCode就是对象的内存地址

       2.   我们会重写hashCode,让hashCode值和对象的内容相关
       3.   hashset底层是哈希表，需要重写hashcode()和equales()方法，来保证元素不重复，
            如hashset和linkedhashset，底层不是哈希表的不需要重写，如list集合。
 */
public class Demo_Hashcode {
    public static void main(String[] args) {

        Cup paris = new Cup("Paris", 3);
        Cup hp = new Cup("Paris", 3);

        System.out.println(paris);  // demo7.Cup@8e1003f8
        System.out.println(paris.hashCode());  //  -1911553032
        System.out.println(Integer.toHexString(paris.hashCode()));  //8e1003f8

        System.out.println("通话".hashCode()); //1179395
        System.out.println("重地".hashCode()); //1179395
    }
}
