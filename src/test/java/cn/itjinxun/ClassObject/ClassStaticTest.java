package cn.itjinxun.ClassObject;

public class ClassStaticTest {
    private static final int MAX_COUNT;
    private static int count;

    public ClassStaticTest() throws Exception{
        count++;
        if(count > MAX_COUNT){
            throw new Exception("只能创建"+MAX_COUNT+"个实例");
        }
        //MAX_COUNT = 8;
    }

    // 实例代码块/初始化代码块
    {
        System.out.println("代码块1");
    }

    // 静态代码块/静态初始化代码块
    static {
        MAX_COUNT = 6;
        System.out.println("静态代码块2");
    }

    // 实例代码块/初始化代码块
    {
        System.out.println("代码块3");
    }

    public static void println(){
        System.out.println("总共有"+count+"个实例");
    }

    public static void main(String[] args) throws Exception {
        ClassStaticTest cst1 = new ClassStaticTest();
        ClassStaticTest cst2 = new ClassStaticTest();
        cst2.println();
        ClassStaticTest cst3 = new ClassStaticTest();
        ClassStaticTest cst4 = new ClassStaticTest();
        ClassStaticTest cst5 = new ClassStaticTest();
        /*ClassStaticTest cst6 = new ClassStaticTest();
        ClassStaticTest.println();
        ClassStaticTest cst7 = new ClassStaticTest();
        ClassStaticTest.println();*/
    }
}
