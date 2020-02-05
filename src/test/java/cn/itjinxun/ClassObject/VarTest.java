package cn.itjinxun.ClassObject;

public class VarTest {
    //使用static修饰的类变量，所有实例共享
    public static int count;
    //没有使用static修饰的类变量，每个示例有单独的拷贝
    public int index;

    public VarTest(){
    }
    public VarTest(int index){
        this.index = index;
    }
    public VarTest(int index, int count){
        //this();
        this(index);
        this.count = count;
    }

    public void println(){
        System.out.println(String.format("当前创建第%d个实例，共%d个",index,count));
    }

    public static void main(String[] args) {
        VarTest vt1 = new VarTest();
        vt1.index = 1;
        vt1.count++;
        vt1.println();
        //System.out.println("当前创建第" + vt1.index + "实例，共有" + VarTest.count + "个");
        VarTest vt2 = new VarTest();
        vt2.index = 2;
        vt2.count++;
        vt2.println();
        //System.out.println("当前创建第" + vt2.index + "实例，共有" + VarTest.count + "个");
        System.out.println("vt2看到的count = " + vt2.count);
        System.out.println("vt1看到的count = " + vt1.count);
        System.out.println("vt1看到的index = " + vt1.index);
        System.out.println("vt2看到的index = " + vt2.index);

        VarTest vt3 = new VarTest(3,3);
        vt3.println();
        System.out.println("vt3看到的index = " + vt3.index);
        System.out.println("vt3看到的count = " + vt3.count);
    }
}
