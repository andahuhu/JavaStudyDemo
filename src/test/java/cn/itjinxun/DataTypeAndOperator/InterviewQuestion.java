package cn.itjinxun.DataTypeAndOperator;

import org.junit.Test;

public class InterviewQuestion {
    @Test
    public void test1(){
        Integer num1 = 127;
        Integer num2 = 127;
        Integer num3 = 128;
        Integer num4 = 128;
        System.out.println((num1 == num2)+","+(num3 == num4));
    }

    @Test
    public void test2(){
        Double d1 = 127D;
        Double d2 = 127D;
        Double d3 = 128D;
        Double d4 = 128D;
        System.out.println((d1 == d2)+","+(d3 == d4));
    }

    @Test
    public void test3(){
        Integer num1 = 127;
        Integer num2 = new Integer(127);
        System.out.println((num1 == num2)+","+(num1.equals(num2)));
    }

    @Test
    public void test4(){
        int num1 = 127;
        Integer num2 = new Integer(127);
        int num3 = 128;
        Integer num4 = new Integer(128);
        System.out.println((num1 == num2)+","+(num2.equals(num1))+","+(num3 == num4)+","+(num4.equals(num3)));
    }

    @Test
    public void test5(){
        Integer num1 = Integer.MAX_VALUE;
        Integer num2 = num1*num1;
        System.out.println(num2);
    }
}
