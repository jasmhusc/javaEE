package demo1;

/**
 * java.lang.包：
 * 根类Throwable：
 * Error: 严重错误Error,如宕机,内存溢出，系统崩溃
 * Exception：异常,可以处理
 * <p>
 * public void printStackTrace() :
 * 打印异常的详细信息。
 * 包含了异常的类型,异常的原因,还包括异常出现的位置,在开发和调试阶段,都得使用printStackTrace。
 * public String getMessage() :
 * 获取发生异常的原因。
 * 提示给用户的时候,就提示错误原因。
 * public String toString() :
 * 获取异常的类型和异常描述信息(不用)。
 */
public class Demo_Exception {
    public static void main(String[] args) {

        int[] arr = {1, 3, 5};
        try {
            System.out.println(arr[3]);

        } catch (Exception e) {
            // 1. printStackTrace() 打印异常详细信息
            e.printStackTrace();
            //java.lang.ArrayIndexOutOfBoundsException: 3
            //	at demo1.Demo_Exception.main(Demo_Exception.java:23)

            // 2. getMessage() 获取异常原因
//            System.out.println(e.getMessage());  // 3

            // 3. toString() 获取异常类型和描述信息 （不用）
//            System.out.println(e.toString()); //java.lang.ArrayIndexOutOfBoundsException: 3
        }
    }
}
