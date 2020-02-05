package cn.itjinxun.ClassObject;

public class JavaClassCompose {
    // 类变量/静态域变量
    private static String classField;

    // 实例变量/域变量
    private String field;

    // 实例代码块/初始化代码块
    {
        System.out.println("类里，方法之外用大括号括起来的一段代码");
    }

    // 静态代码块/静态初始化代码块
    static {
        System.out.println("类里，方法之外用大括号括起来且前面用static修饰的一段代码");
    }

    // 构造方法
    public JavaClassCompose() {}

    // 方法
    public void method() {}

    // 内部类
    class InnerClass {
    }
}
