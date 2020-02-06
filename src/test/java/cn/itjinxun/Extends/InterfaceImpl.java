package cn.itjinxun.Extends;

public class InterfaceImpl implements Interface,Interface2 {
    @Override
    public void method() {
        System.out.println("我是一个方法");
    }

    @Override
    public void method2() {
        System.out.println("我是一个方法2");
    }
}
