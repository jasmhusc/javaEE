package demo2;

import javafx.fxml.LoadException;

import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * 方法内有异常抛出 throw ,且main方法直接进行try catch捕获处理
 */
public class Demo_trycatch {
    public static void main(String[] args) {
//      连续抓异常
        try {
            read("aa.txt");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (LoadException e) {
            e.printStackTrace();
        }
//        一次捕获
        /*try {
            read("aa.txt");
        }catch (Exception e){
            e.toString();
        }*/
    }

    private static void read(String path) throws FileNotFoundException, LoadException {

        if (!path.equals("aaa.txt")) {
            // // 我假设 如果不是 a.txt 认为 该文件不存在 是一个错误 也就是异常 throw
            throw new FileNotFoundException("文件不存在！");
        }
        if (path.equals("bbb.txt")) {
            throw new LoadException("读取异常！");
        }
    }
}
