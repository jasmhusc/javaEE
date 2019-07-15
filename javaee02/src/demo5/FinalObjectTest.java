package demo5;

class FinalObject {
	int a =10;
}
public class FinalObjectTest {

	public static void main(String[] args) {
		final FinalObject objc1 = new FinalObject();
		System.out.println(objc1.a);
		objc1.a = 20;        // 可以改变对象内的值
		System.out.println(objc1.a);    

		//objc1 = new FinalObject();    // 不能指向新的空间
	}
}

