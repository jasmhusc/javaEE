package demo5;

/*
目标:学习接口私有方法的使用

讲解:
    私有方法格式:
        private 返回值类型 方法名() {
        }

    接口_私有方法的使用:私有方法只有本类/接口能用

小结:
    接口_私有方法的使用:
        1.给本接口的默认方法使用
        2.给本接口的静态方法使用
 */
public class Demo5 {
    public static void main(String[] args) {
        // 接口私有方法,在实现类中不能使用
        // Student s = new Student();
        // s.test01();
    }
}
