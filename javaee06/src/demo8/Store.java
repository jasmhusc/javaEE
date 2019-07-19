package demo8;

import java.util.*;

public class Store {
    private Scanner sc;
    private HashMap<String, ArrayList<Book>> bookstore;

    public Store() {
        sc = new Scanner(System.in);
        bookstore = new HashMap<>();
        ArrayList list1 = new ArrayList();
        list1.add(new Book("西游记", 19.0));
        list1.add(new Book("水浒传", 29.0));
        bookstore.put("名著", list1);
        ArrayList list2 = new ArrayList();
        list2.add(new Book("JAVA入门到精通", 39.8));
        list2.add(new Book("PHP入门到入土", 9.9));
        bookstore.put("it", list2);
    }

    public void add() {
        System.out.println("输入添加书籍的类型：");
        String type = sc.next();
        // 如果不包含该类别，就创建新的类别
        if (!bookstore.keySet().contains(type)) {
            bookstore.put(type, new ArrayList<>());
        }

        System.out.println("输入书籍的名称：");
        String name = sc.next();
        // 再该类别下，看看书籍是否存在
        if (isExist(type, name)) {
            System.out.println("书籍已经存在");
            return;
        }

        System.out.println("输入书籍的价格：");
        double price = sc.nextDouble();
        Book book = new Book(name, price);

        // 如果存在该类别，且没有该书，就直接添加
        bookstore.get(type).add(book);
        System.out.println("添加成功");
    }

    public Book remove() {
        Book book = null;
        // 获取删除书籍的信息
        // 判断类型是否存在
        System.out.println("输入添加书籍的类型：");
        String type = sc.next();
        if (!bookstore.keySet().contains(type)) {
            System.out.println("不存在该类型书籍");
            return book;
        }
        System.out.println("输入书籍的名称：");
        String name = sc.next();
        // 判断有没有该书籍
        if (isExist(type, name)) {
            ArrayList<Book> books = bookstore.get(type);
            book = getByName(type, name);
            books.remove(book);
            System.out.println("删除成功！");
        } else {
            System.out.println("该书不存在");
        }
        return book;
    }

    public void set() {
        // set新的信息
        // 判断类型是否存在
        System.out.println("输入修改书籍的类型：");
        String type = sc.next();
        if (!bookstore.keySet().contains(type)) {
            System.out.println("不存在该类型书籍");
            return;
        }
        // 判断书名是否存在
        System.out.println("输入书籍的名称：");
        String name = sc.next();
        Book oldbook = getByName(type, name);
        if (oldbook == null) {
            System.out.println("该书不存在");
            return;
        }
        // 设置信息
        System.out.println("输入书籍新的名称：");
        oldbook.setName(sc.next());
        System.out.println("输入书籍的价格：");
        oldbook.setPrice(sc.nextDouble());
        System.out.println("修改成功");
    }

    public void list() {
        // 展示栏目
        System.out.println("类型\t\t书名\t\t价格");
        // 遍历所有书籍，并根据类别打印
        Set<Map.Entry<String, ArrayList<Book>>> entries = bookstore.entrySet();
        for (Map.Entry<String, ArrayList<Book>> entry : entries) {
            // 得到书的类别和相应的书籍（集合）
            String type = entry.getKey();
            ArrayList<Book> books = entry.getValue();
            if (!books.isEmpty()) {
                System.out.println(type);
                // 遍历集合内的书
                for (Book book : books) {
                    System.out.println("\t\t" + book.getName() + "\t" + book.getPrice());
                }
            }
        }
    }

    public boolean isExist(String type, String name) {
        boolean ret = false;
        // 查看类型是否存在，不存在直接退出
        if (getByName(type, name) != null)
            ret = true;
        return ret;
    }

    public Book getByName(String type, String name) {
        Book ret = null;
        // 查看类型是否存在，不存在直接退出
        if (bookstore.keySet().contains(type)) {
            // 类别正确，再继续看该书是否存在
            ArrayList<Book> books = bookstore.get(type);
            for (Book book : books) {
                String name1 = book.getName();
                if (name1.equals(name)) {
                    ret = book;
                }
            }
        }
        return ret;
    }
}
