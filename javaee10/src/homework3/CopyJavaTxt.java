package homework3;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * 从控制台获取输入的文件目录然后将该目录(包含子目录)下的.java文件复制到D:/java文件夹中,并统计java文件的个数.
 *
 * 提示:如果有相同的名称的文件,如果两个Test01.java,则拷贝到目标文件夹时只能有一个Test01.java,另一个
 * Test01.java要修改为另一个名称:该名称可随机生成,只要不重复即可.
 */
public class CopyJavaTxt {
    public static void main(String[] args) throws Exception {

        // 指定文件加路径
        File file1 = new File("F:\\idea\\javaEE\\javaee09\\src");
        File file2 = new File("D:/java");
        int num = copyJava(file1, file2, 0);
        System.out.println(num);
    }

    private static int copyJava(File fro, File fto, int i) throws Exception {
        if (null == fro)
            throw new NullPointerException("文件路径为空！");
        if (!fro.exists())
            throw new FileNotFoundException("路径错误！");
        if (fro.isDirectory()) {
            File[] files = fro.listFiles();
            if (null == files)
                throw new NullPointerException("文件路径为空！");
            for (File listFile : files) {
                i = copyJava(listFile, fto, i);
            }
        } else {
            // 是否是.java文件
            String name = fro.getName();
            if (name.endsWith(".java")) {
                i++;
                // 复制
                File file = new File(fto, name);
                if (file.exists()) {
                    file = new File(fto, System.currentTimeMillis() + name);
                }
                FileReader fr = new FileReader(fro);
                FileWriter fw = new FileWriter(file);
                int len;
                char[] arr = new char[1024];
                while ((len = fr.read(arr)) != -1) {
                    fw.write(arr, 0, len);
                    fw.write("\r\n");
                }
                // 关流
                fw.close();
                fr.close();
            }
        }
        return i;
    }
}
