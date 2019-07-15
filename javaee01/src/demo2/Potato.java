package demo2;

public class Potato {

	static int price = 5;   //Static静态变量只依赖于类存在，称为类变量，属于类而不属于对象
	String content  = "";
	public Potato(int price,String content) {
	
		this.price = price;
		this.content = content;
	}
	public static void main(String[] args) {
		//Static变量可以通过   类名.变量名访问 --- Potato.price
		System.out.println(Potato.price);
		//System.out.println(Potato.content);
		// 非Static变量不能 Potato.content  wrong
		System.out.println("-------------------------------------");
		Potato objc1 = new Potato(10,"青椒土豆丝");
		System.out.println(Potato.price+"\t"+objc1.price);
		System.out.println("-------------------------------------");
		Potato objc2 = new Potato(20,"酸辣土豆丝");
		System.out.println(Potato.price+"\t"+objc2.price+"\t"+objc1.price);
		System.out.println(objc1.content+"\t"+objc2.content);
		//所有对象关于静态变量price的值共享一个存储空间，即objc1，objc2,...都指向一个 price。
	}

}
