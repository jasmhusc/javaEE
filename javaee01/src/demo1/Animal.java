package demo1;
/*
* 如果一个类所有方法都没有实现，都是抽象方法，该类就是接口;
* 接口不算类，或者说是特殊的类.
* */
public interface Animal{
/*
抽象类和接口相同点：
	两者都不能被实例化，即不能进行 new 操作。
抽象类和接口不同点：
	1.一个类只能继承一个（抽象）类，可以实现多个接口.
	2.抽象类可以部分方法实现，但是接口所有方法都不能实现.
	3.接口可以继承多个接口，没有实现的方法会叠加.
	4.抽象类有构造函数，接口没有构造函数.
	5.抽象类可以有main，也能运行，接口没有main函数.
	6.抽象类可以有private/protected，接口所有方法均是：public，如下：
		a. public abstract ---- 默认给定。
		b. public default ---- 必须有方法体，不能被子接口继承，可以被抽象类继承，使用和重写。
		c. public static --- 必须给定方法体，可以接口名.调用。
	7.同时实现多个接口，且包含同名方法，只需实现一次，不会报错。
*/

	void eat();
	public abstract void move();

	public static void sleep(){

		System.out.println("666");
	}

	public default double ran(){

		return Math.random();
	}
}
