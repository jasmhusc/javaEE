package demo7;

public class Star {
    private String name;
    private Sex sex;

    public Star() {
    }

    public Star(String name, Sex sex) {
        this.name = name;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public void show() {
        System.out.println("大家好，我是"+name+",我是"+sex);
    }
}
