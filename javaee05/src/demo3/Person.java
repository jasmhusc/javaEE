package demo3;

public class Person implements Comparable<Person> {

    private String name;
    private int age;

    public Person() {
        super();
    }

    public Person(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person [name=" + name + ", age=" + age + "]";
    }

    @Override
    public boolean equals(Object obj) {
        Person p = (Person) obj;
        return this.name.equals(p.getName()) && this.age == p.age;
    }

    @Override
    // 按年龄排序，姓名次要
    public int compareTo(Person o) {
        int num = this.age - o.age;
        return num == 0 ? this.name.compareTo(o.name) : num;
    }


}
