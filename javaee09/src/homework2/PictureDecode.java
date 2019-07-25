package homework2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 解密cmdcopy图片
 */
public class PictureDecode {
    public static void main(String[] args) throws IOException {
        // 创建输入输出流
        FileInputStream fis = new FileInputStream("javaee09/file/cmdcopy.png");
        FileOutputStream fos = new FileOutputStream("javaee09/file/cmddecode.png");

        // 读取文件并复制
        int len;
        byte[] arr = new byte[1024 * 2];
        while ((len = fis.read(arr)) != -1) {
            for (int i = 0; i < arr.length; i++) {
                arr[i] ^= 8;
            }
            fos.write(arr, 0, len);
        }
    }
}
