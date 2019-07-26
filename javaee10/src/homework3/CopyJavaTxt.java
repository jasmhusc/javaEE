package homework3;

import java.io.File;

/**
 * 将一个文件夹内的.java文件全部复制到另一个文件。
 */
public class CopyJavaTxt {
    public static void main(String[] args) {

        // 指定文件加路径
        File file1 = new File("F:/myjavafile/dirs");
        File file2 = new File("F:/myjavafile/dirs");
        copyJava(file1, file2, 0);
    }

    private static int copyJava(File fro, File fto, int i) {

        return i;
    }
}
