package itjinxun.InnerClass;

public class PrintClass {
    //private String name;
    protected String name;

    /*public PrintClass() {
    }*/

    public PrintClass(String name) {
        this.name = name;
        System.out.println("调用了父类的构造器name="+this.name);
    }

    public void print(){
        System.out.println("我是打印");
    }
}
