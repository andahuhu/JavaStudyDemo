package cn.itjinxun.ClassObject;

public class ClassCreateTest {
    private String name;
    private static int max_count;
    {
        name = "这是一个成员变量";
        System.out.println("执行代码块1");
    }
    static {
        max_count = 10;
        System.out.println("执行静态代码块1");
    }
    public ClassCreateTest(){
        System.out.println("执行构造器");
    }
    public void println(){
        System.out.println(name);
    }
    public static void main(String[] args) {
        new ClassCreateTest().println();
        new ClassCreateTest().println();
    }
    {
        name = "这是一个成员变量";
        System.out.println("执行代码块2");
    }
    static {
        System.out.println("执行静态代码块2");
    }
}
