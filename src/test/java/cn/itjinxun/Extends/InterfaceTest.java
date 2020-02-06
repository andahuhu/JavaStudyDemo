package cn.itjinxun.Extends;

import org.junit.Test;

public class InterfaceTest {
    @Test
    public void testInterface(){
        //Interface i1 = new Interface();
        InterfaceImpl i2 = new InterfaceImpl();
        i2.method();
        i2.method2();
        i2.print();
        System.out.println(i2 instanceof Interface);
        System.out.println(i2 instanceof Interface2);

        System.out.println(Interface.MAX_COUNT);
        System.out.println(InterfaceImpl.MAX_COUNT);
        System.out.println(i2.MAX_COUNT);

        Interface.print0();
        //InterfaceImpl.MAX_COUNT;
        //i2.MAX_COUNT;
    }
}
