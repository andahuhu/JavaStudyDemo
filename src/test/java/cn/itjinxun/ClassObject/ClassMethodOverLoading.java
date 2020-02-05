package cn.itjinxun.ClassObject;

import org.junit.Test;

public class ClassMethodOverLoading {
    public void println(){}

    public void println(int num){}

    public void println(String str){}

    public void println(int num1, int num2){}

    @Test
    public void testOverLoading(){
        println();
        println(1);
        println("123");
        println(1,2);
    }
}
