package demo2;

import java.util.Comparator;
import java.util.TreeSet;

public class Lambda2 {
    public static void main(String[] args) {

        /*TreeSet<Student> set = new TreeSet<>(new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 年龄升序，年龄大的排在后面
                return o1.getAge()-o2.getAge();
            }
        });*/

        TreeSet<Student> set = new TreeSet<Student>((s1, s2) -> s1.getAge() - s2.getAge());

        set.add(new Student("李小璐", 18));
        set.add(new Student("刘岩", 24));
        set.add(new Student("张馨予", 22));

        /*for (Student s : set) {
            System.out.println(s);
        }*/

        // Stream
        set.forEach(System.out::println);
    }
}

class Student {
    private String name;
    private int age;

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
