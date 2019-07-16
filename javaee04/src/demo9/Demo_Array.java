package demo9;

/**
 * 数组： 可以接收基本数据类型 引用数据类型
 * 集合： 只能接收引用数据类型
 */
public class Demo_Array {
    public static void main(String[] args) {
        // 数组接收引用数据类型
        String[] str = new String[]{"paul", "boby", "jane"};
        Student[] stus = {new Student("cosins"), new Student("cury")};
        for (Student student : stus) {
            System.out.println(student.getName());
        }
    }

    public static String getWeek(int i) {

        String[] arr = {"", "星期日", "星期一", "星期二", "星期三", "星期四", "星期五", "星期六"};
        return arr[i];
    }
}

// 自定义类
class Student {
    private String name;

    public Student() {
    }

    public Student(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}