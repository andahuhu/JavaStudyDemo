package cn.itjinxun.ClassObject;

import org.junit.Test;

public class ClassThisTest {
    private int index;

    public ClassThisTest(){
    }

    public void println(String name){
        System.out.println(this.index + " . hello , " + name);
    }

    public void println(int... nums){
        if(nums == null){
            System.out.println("is null");
            return;
        }
        if(nums.length == 0){
            System.out.println("param length is zero");
            return;
        }
        System.out.println("打印可变参数开始。。。");
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    @Test
    public void testThis(){
        ClassThisTest obj = new ClassThisTest();
        obj.println("zhangsan");
    }

    @Test
    public void testPrintln(){
        println();
        println(1);
        println(1,3,5,78,10);
    }
}
