package cn.itjinxun.CodeBlockAndFlowControl;

import itjinxun.CodeBlockAndFlowControl.AgeCheck;
import itjinxun.CodeBlockAndFlowControl.FlowControl;
import org.junit.Assert;
import org.junit.Test;

import java.util.Random;

public class FlowControlTest {
    @Test
    public void ifElseTest(){
        FlowControl ifElse = new FlowControl();
        ifElse.decideAge(3);
        ifElse.decideAge(13);
        ifElse.decideAge(23);
        ifElse.decideAge(53);
        ifElse.decideAge(73);
        ifElse.decideAge(303);
    }

    @Test
    public void whileTest(){
        //随机生成一个 0 ～ 1000 范围的整数，如果不能被30整除，则打印出数字，如果能被30整除则退出循环
        boolean isContinue = true;
        int times = 0;
        while (isContinue) {
            int r = new Random().nextInt(1000);
            if (r%30 == 0) {
                isContinue = false;
                System.out.println(r + "能被30整除，退出程序");
            } else {
                System.out.println(r + "不能被30整除，继续");
                times++;
//                times = times + 1;
//                times += 1;
//                ++times;
            }
        }
        System.out.println("循环次数是：" + times);
    }
    @Test
    public void doWhileTest(){
        //随机生成一个 0 ～ 1000 范围的整数，如果不能被30整除，则打印出数字，如果能被30整除则退出循环
        boolean isContinue = true;
        int times = 0;
        do {
            int r = new Random().nextInt(1000);
            if (r%30 == 0) {
                isContinue = false;
                System.out.println(r + "能被30整除，退出程序");
            } else {
                System.out.println(r + "不能被30整除，继续");
                times++;
            }
        } while (isContinue);
        System.out.println("循环次数是：" + times);
    }

    @Test
    public void forCircleTest(){
        //打印 0 ~ 100 范围内的单数并计算范围内单数的总个数
        int total = 0;
        for(int i = 0; i<=100; i++){
            if(i%2 != 0){
                ++total;
                System.out.println(i + "是一个单数");
            }
        }
        System.out.println("0 ~ 100 范围内共有"+total+"个单数");
    }

    @Test
    public void switchTest(){
        FlowControl switchTest = new FlowControl();
        switchTest.receiveOrder(1);
        switchTest.receiveOrder(3);
        switchTest.receiveOrder(6);
    }

    @Test
    public void breakTest(){
        int times = 0;
        while (true) {
            int r = new Random().nextInt(1000);
            if (r%30 == 0) {
                System.out.println(r + "能被30整除，退出程序");
                break;
            } else {
                System.out.println(r + "不能被30整除，继续");
                times++;
            }
        }
        System.out.println("循环次数是：" + times);
    }

    @Test
    public void returnTest(){
        FlowControl returnTest = new FlowControl();
        int num = returnTest.getMaxNumRem7(3,21);
        System.out.println(num);
        num = returnTest.getMaxNumRem7(5,100);
        System.out.println(num);
        num = returnTest.getMaxNumRem7(10,1000);
        System.out.println(num);
        num = returnTest.getMaxNumRem7(8,100);
        System.out.println(num);
    }

    @Test
    public void continueTest(){
        int total = 0;
        for (int i = 0; i <= 100; i++) {
            if(i%7 != 0){
                continue;
            }
            System.out.println(i + "能被7整除");
            total++;
        }
        System.out.println("0 ~ 100 范围内共有"+total+"个能被7整除的数");
    }

    @Test
    public void assertTest(){
        /*
        * 测试驱动开发（Test-Driven Development），简称 TDD。
        * 简单来说就是先写测试，再写实现。
        * 题目：给定一个年龄，然后判断该年龄属于儿童、青年、中年还是老年；
        * 年龄使用 int 类型，只支持整数。
        * */
        Assert.assertEquals(AgeCheck.getAgeName(6),"儿童");
        Assert.assertEquals(AgeCheck.getAgeName(15),"少年");
        Assert.assertEquals(AgeCheck.getAgeName(20),"青年");
        Assert.assertEquals(AgeCheck.getAgeName(45),"中年");
        Assert.assertEquals(AgeCheck.getAgeName(71),"老年");
        Assert.assertEquals(AgeCheck.getAgeName(300),"异常年龄");
    }
}
