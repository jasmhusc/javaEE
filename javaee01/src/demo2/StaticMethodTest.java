package demo2;

public class StaticMethodTest {

	int a = 111;
	static int b = 222;
	public static void hello() {
		System.out.println("000");
		System.out.println(b);
		//System.out.println(a);  error,can not call non-static variables
		//hi();    error , can not call non-static method
	}
	
	public void hi() {
		System.out.println("333");
		System.out.println(b);   // ok, can call static variables
		System.out.println(a);  //ok, can call non-static variables
		hello();               // ok, can call non-static method
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StaticMethodTest.hello();
		//StaticMethodTest.hi();  不能使用类名来引用非静态方法
		StaticMethodTest foo = new StaticMethodTest();
		foo.hello();  // waring , but it is ok ; 建议使用类名访问而不是对象访问
		foo.hi();    // ok

	}

}
