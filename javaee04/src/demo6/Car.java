package demo6;

/*
定义一辆车,这辆车即能够装二师兄也能够装人
1.定义类时声明泛型
<E>:声明泛型,相当于定义一个变量 int x
 */
public class Car<E> {

    private E car;

    public Car() {
    }

    public Car(E car) {
        this.car = car;
    }

    public void setCar(E car) {
        this.car = car;
    }

    public E getCar() {
        return car;
    }
}
