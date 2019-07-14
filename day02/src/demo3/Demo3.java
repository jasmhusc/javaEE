package demo3;

/**
 * 讲解:
 *     JDK1.8以前
 *     interface 接口名 {
 *         抽象方法;
 *     }
 *
 *     在JDK1.8以后接口新增了其他方法(了解)
 *         interface 接口 {
 *             默认方法; (JDK1.8)
 *             静态方法; (JDK1.8)
 *             私有方法; (JDK1.9)  此版本为 jdk1.8.212，不能使用
 *         }
 *
 *
 *     默认方法的格式:
 *         修饰符 default 返回值类型 方法名(参数列表) {
 *         }
 *
 *         和普通方法相比: 在返回值类型前面添加default
 *
 *     接口_默认方法的使用:
 *         1.实现类直接使用
 *         2.实现类可以重写默认方法
 *
 * 小结:
 *     接口_默认方法的使用:
 *         1.实现类直接使用
 *         2.实现类可以重写默认方法
 */
public class Demo3 {
    public static void main(String[] args) {
        Teacher teacher = new Teacher();
        teacher.swim();
    }
}
