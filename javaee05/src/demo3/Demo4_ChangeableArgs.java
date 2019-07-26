package demo3;

public class Demo4_ChangeableArgs {

    public static void main(String[] args) {

        int[] arr = {11, 22, 33, 44, 55};
        print(arr);
        System.out.println("-----------------");
        print(11, 22, 33, 44);
        System.out.println("-----------------");
        print();
    }                      // 有多个参数时，可变参数要放在最后

    private static void print(int... arr) {       // 可变参数其实是数组，和下面  int[] arr 类似，但更加强大
        for (int i = 0; i < arr.length; i++) {

            System.out.println(arr[i]);
        }
    }

//	private static void print(int[] arr) {
//		
//		for (int i = 0; i < arr.length; i++) {
//			
//			System.out.println(arr[i]);
//		}
//		
//	}


}
