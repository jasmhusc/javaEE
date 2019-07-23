package homework6;

public class TestInvokeDirect {
    public static void main(String[] args) {
        // 分别使用Lambda[标准格式]及[省略格式]调用invokeDirect方法
        invokeDirect(() -> System.out.println("导演拍电影啦"));

    }

    private static void invokeDirect(Director director) {
        director.makeMovie();
    }
}
