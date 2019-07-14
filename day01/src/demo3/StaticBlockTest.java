package demo3;

public class StaticBlockTest {

	//static block >> anonymous block >> consructor function
	static {
		System.out.println("11111");    //在类第一次加载时调用，且只此一次
	}

	{
		System.out.println("22222");    //匿名代码块按顺序调用
	}

	public StaticBlockTest() {          //构造函数最后调用
		System.out.println("33333");
	}

	{
		System.out.println("44444");
	}
	
	public static void main(String[] args) {
		System.out.println("aaaa");
		StaticBlockTest sbt1 = new StaticBlockTest();
		StaticBlockTest sbt2 = new StaticBlockTest();
	}
}
