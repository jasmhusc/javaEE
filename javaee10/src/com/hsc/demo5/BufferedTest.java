package com.hsc.demo5;

import java.io.*;
import java.util.HashMap;
import java.util.Set;

/**
 * 1. 逐行读取文本信息。
 * 2. 解析文本信息到集合中。
 * 3. 遍历集合，按顺序，写出文本信息
 */
public class BufferedTest {
    public static void main(String[] args) {

        // 使用BufferedReader来读取文本
        try (
                BufferedReader br = new BufferedReader(new FileReader("javaee10/file/test.txt"));
                BufferedWriter bw = new BufferedWriter(new FileWriter("javaee10/file/text.txt"));
        ) {
            String line;
            HashMap<Integer, String> map = new HashMap<>();
            while ((line = br.readLine()) != null) {
                // 将每一行数据拆分，存储金map集合
                String[] split = line.split("\\."); //[.]
                Integer key = Integer.parseInt(split[0]);
                map.put(key, split[1]);
            }
            // 将集合数据按照key的顺序写出
            Set<Integer> keySet = map.keySet();
            for (int i = 1; i <= keySet.size(); i++) {
                String s = map.get(i);
                bw.write(i + "." + s);
                if (i != 9)
                    bw.newLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
