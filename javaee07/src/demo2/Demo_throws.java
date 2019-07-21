package demo2;

import java.io.FileNotFoundException;

/*
声明异常：将问题标识出来，报告给调用者。如果方法内通过throw抛出了编译时异常，
    而没有捕获处理，那么必须通过throws进行声明，让调用者去处理。
 */
public class Demo_throws {
    public static void main(String[] args) throws FileNotFoundException {

        // thorws 声明异常
        // main方法也没有try catch，继续throws给JVM
        // JVM可以识别该异常, 并且默认处理方式是：e.printStackTrace()
        write("aaa.txt");
    }

    private static void write(String pathName) throws FileNotFoundException {
        /*
         指定文件路径必须为"bbb.txt"，否则认为不存在;
         这里没用处理--try catch
         方法名上必须抛出 throws, 继续抛给main方法
          */
        if ("bbb.txt".equals(pathName)) {
            throw new FileNotFoundException("大哥，文件不存在");
        }
    }
}
