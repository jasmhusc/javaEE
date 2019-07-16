package demo9;

public class Demo3_System {

    public static void main(String[] args) {

        // system.exit(0);  退出java虚拟机
        for (int i = 0; i < 4; i++) {
            // 产生垃圾
            new Demo();        // 不主动调用  finalize
            System.gc();      //  运行垃圾回收器，主动呼唤  finalize 回收垃圾
        }
    }
}

class Demo {

    @Override
    public void finalize() {
        System.out.println("垃圾被回收了！");
    }
}