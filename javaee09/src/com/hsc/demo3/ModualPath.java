package com.hsc.demo3;

import java.io.File;
import java.io.IOException;

/*
    创建相对路径，加上Modual名称和文件加名称，且不能一次性创建
    注意:
        WINDOWS中文件名不区分大小写
        WINDOWS中路径分隔符可以写反斜杠\,也可以写正斜杠/
 */
public class ModualPath {
    public static void main(String[] args) throws IOException {
        // 往此Modual下create文件，相对目录
        File fatherPath = new File("javaee09/src");
        File file = new File(fatherPath, "a.txt");
        file.createNewFile();
    }
}
