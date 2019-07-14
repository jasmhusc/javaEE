package demo1;

public class Dog extends LandAnimal {

	/**move()方法在抽象类：LandAnimal 中已经实现
	 * 只需再重写 eat() 方法
 	 */

	@Override
	public void eat() {
		System.out.println("Dog:I Can Eat Bones!");
	}

}
