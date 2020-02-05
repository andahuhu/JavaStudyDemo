package cn.itjinxun.ClassObject1;

import cn.itjinxun.ClassObject.ClassAccess;
import org.junit.Test;

public class ClassAccess3 extends ClassAccess {
    @Test
    public void testAccess(){
        System.out.println(pub);
        System.out.println(pro);
        //System.out.println(def);
        //System.out.println(ca.pri);

        System.out.println(getPub());
        System.out.println(getPro());
        //System.out.println(getDef());
        //System.out.println(ca.getPri());
    }
}
