package cn.itjinxun.DataTypeAndOperator;

import itjinxun.DataTypeAndOperator.HomeWork;
import org.junit.Test;

public class HomeWorkTest {
    @Test
    public void testEquals(){
        HomeWork homeWork = new HomeWork();
        Integer n1 = 123;
        Integer n2 = new Integer(123);
        System.out.println(homeWork.equals(n1,n2));
    }
}
