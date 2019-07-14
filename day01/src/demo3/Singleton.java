package demo3;

public class Singleton {

	private static Singleton obj = new Singleton();
	private String content;
	private Singleton() {
		this.content = "abcd";
	}
	
	public String getContent() {
		return content;
	}
	
	public void setContent (String content) {
		this.content = content;
	}
	
	public static Singleton getInstance() {
		
		return obj;
	}
	public static void main(String[] args) {
		Singleton kk = new Singleton ();
		kk.setContent("efghijk");
		System.out.println(kk.getContent());
		
		Singleton obj1 = Singleton.getInstance();
		System.out.println(obj1.getContent());
		
		Singleton obj2 = Singleton.getInstance();
		System.out.println(obj2.getContent());
		
		obj2.setContent("efg");
		System.out.println(obj1.getContent());
		System.out.println(obj2.getContent());
		
		System.out.println(obj1==obj2);

	}


}
