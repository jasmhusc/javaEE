package demo8;

import java.util.Scanner;

public class BookSys {
    private static Store store;
    private static Scanner sc;

    public BookSys() {
        store = new Store();
        sc = new Scanner(System.in);
    }

    private void showPrompt() {
        // 展示欢迎语句和操作提示语句
        System.out.println("--------欢迎来到图书管理系统--------");
        System.out.println("1.查看书籍");
        System.out.println("2.添加书籍");
        System.out.println("3.删除书籍");
        System.out.println("4.修改书籍");
        System.out.println("5.退出");
        System.out.println("请输入你的选择：");
    }

    private void start() {
        showPrompt();
        // 接收用户操作指令
        while (true) {
            String cmd = sc.next();
            switch (cmd) {
                case "1":
                    //1.查看书籍
                    store.list();
                    break;
                case "2":
                    //2.添加书籍
                    store.add();
                    break;
                case "3":
                    //3.删除书籍
                    store.remove();
                    break;
                case "4":
                    //4.修改书籍
                    store.set();
                    break;
                case "5":
                    //5.退出
                    System.exit(0);
                default:
                    System.out.println("大爷，不要乱来啊！");
                    break;
            }
        }
    }

    public static void main(String[] args) {
        new BookSys().start();
    }
}
