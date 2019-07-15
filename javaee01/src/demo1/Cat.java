package demo1;

public class Cat extends LandAnimal implements CatFamily,Animal{
	@Override
	public void eat() {
		System.out.println("Cat:I Can Eat!");
	}

	@Override
	public void move() {
		System.out.println("Cat:I Can Move!");
	}

	@Override
	public void climb() {
		// 有方法体即可，可以什么都不做。
	}

	public static void main(String[] args) {
		Cat cat = new Cat();
		cat.eat();
		cat.climb();
//		cat.sleep();  接口内的静态方法不能被实现类对象调用
	}
}