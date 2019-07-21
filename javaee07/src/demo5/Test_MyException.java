package demo5;

public class Test_MyException {
    public static void main(String[] args) {

        Student student = new Student("樱木花道", 18);
        // 直接捕获异常
        try {
            student.setAge(170);
            System.out.println(student.getAge());
        } catch (AgeOutOfBoundsException e) {
            e.printStackTrace();
        }
    }
}

class Student {
    private String name;
    private int age;

    public Student() {
    }

    public Student(String name, int age) {
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

    public void setAge(int age) throws AgeOutOfBoundsException {
        if (age > 0 && age < 150) {
            this.age = age;
        } else {
            // Exception e = new AgeOutOfBoundsException("年龄非法");
            // throw e;
            throw new AgeOutOfBoundsException("年龄非法");
        }
    }
}
