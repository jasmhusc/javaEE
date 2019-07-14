package demo1;

public class Tiger implements CatFamily{

	// Tiger实现CatFamily接口，并重写所有抽象方法
	 @Override
	 public void eat() {
   	  System.out.println("Tiger:I Can Eat!");
     } 

     @Override
	 public void move() {
   	  System.out.println("Tiger:I Can Move By Feet!");
     } 

     @Override
	 public void climb() {
   	  System.out.println("Tiger:I Can climb!");
     }
	

}
