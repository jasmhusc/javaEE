package demo6;
/* 懒汉式1
public class Singleton {

	private Singleton() {};
	private static Singleton instance;
	
	public static Singleton getInstance() {
		
		if(instance == null)
			instance = new Singleton();
		return instance;
	}
}*/

/* 懒汉式2
public class Singleton {
  
    private Singleton() {}; 
    private static Singleton instance;
 
    public static synchronized Singleton getInstance() {
  
         if(instance == null) 
	         instance = new Singleton(); 
         return instance;  
         } 
    }*/

/* 饿汉式 */
public class Singleton {
    private Singleton() {
    }

    ;
    private static Singleton instance = new Singleton();

    public static Singleton getInstance() {

        return instance;
    }
}
 

/* 双检锁/双重校验锁 double-checked locking
public class Singleton {
	private Singleton() {};
	private static Singleton instance;
	
	public static Singleton getInstance() {
		
		if(instance == null)
			synchronized(Singleton.class) {
				if(instance == null)
					instance = new Singleton();
			}
		return instance;
		
	}
}
*/

/* 静态内部类
public class Singleton {
	private Singleton() {};

	private static class SingletonHolder {
		private static final Singleton INSTANCE = new Singleton();
	}

	public static Singleton getInstance() {
		return SingletonHolder.INSTANCE;
	}
}
*/

/* 枚举
public enum Singleton{	
	
	INSTANCE;
	public void whateverMethod() {
		
	}
}
*/