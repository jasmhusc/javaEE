package demo5;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Scanner;

/**
 * 一条语句出现可能出现多种异常：
 * 嵌套处理，try- catch
 */
public class Test_MultipleExcep {
    public static void main(String[] args) {

        // 键盘录入一个整数
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个整数：");

        /*
         将其转换为整数，在转换为二进制,
         循环录入直到正确为止
          */
        while (true) {
            String line = scanner.nextLine();
            try {
                String s = Integer.toBinaryString(Integer.parseInt(line));
                System.out.println("该整数的二进制为：" + s);
                break;
            } catch (Exception e1) {

                try {
                    // 有可能是整数过大，用bigInteger接收一下，看能否成功
                    new BigInteger(line);
                    System.out.println("输入的整数过大，请重新输入：");
                } catch (Exception e) {
                    try {
                        // 上面的try没走，可能是输入的小数
                        new BigDecimal(line);
                        System.out.println("输入的是小数，请重新输入：");
                    } catch (Exception e2) {
                        // 上面三个try都没走，说明存在异常，但不是整数过大和小数，那么是字符
                        System.out.println("输入的是字符，请重新输入：");
                    }
                }
            }
        }
    }
}
