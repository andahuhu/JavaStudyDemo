package cn.itjinxun.Extends;

import org.junit.Test;

public class AbstractTest {
    @Test
    public void testAbstract(){
        Person p1 = new Teacher();
        System.out.println(p1.getDescrition());
        Person p2 = new Student();
        System.out.println(p2.getDescrition());
        /*Person p3 = new Person();
        System.out.println(p3.getDescrition());*/
    }
}
