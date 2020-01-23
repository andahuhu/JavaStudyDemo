package cn.itjinxun.DataTypeAndOperator;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OperatorTest {
    @Test
    public void test1() {//运算符
        Object ob1 = new Object();
        Object ob2 = new Object();
        System.out.println(ob1 == ob2);
        System.out.println(ob1 != ob2);

        String str1 = "Hello" + " ";
        str1 += "World";
        System.out.println(str1);

        int n1 = 1;
        int n2 = 1;
        int n3 = n1 + n2;
        System.out.println(n3);
//      两个byte相加，返回值的类型是int,所以下面语句报错
        byte b1 = 1;
        byte b2 = 1;
//      byte b3 = b1 + b2;
//      两个short相加，返回值的类型是int，所以下面语句报错
        short s1 = 1;
        short s2 = 2;
//      short s3 = s1 + s2;

        Set set = new HashSet();
        set.add(s1);
        set.add(s2);
        System.out.println(set);
        set.remove(s1 + 1);
        System.out.println(set);
        set.remove((short) (s1 + 1));
        System.out.println(set);
    }

    @Test
    public void test2() {//算术运算符
        System.out.println(3 + 2);
        System.out.println(3 - 2);
        System.out.println(3 * 2);
        System.out.println(3 / 2);
        System.out.println(3 % 2);
        System.out.println(3 / 2.0);
        System.out.println("=============================");

        int n1 = 3;
        n1 += 2;
        System.out.println(n1);

        n1 = 3;
        n1 -= 2;
        System.out.println(n1);

        n1 = 3;
        n1 *= 2;
        System.out.println(n1);

        n1 = 3;
        n1 /= 2;
        System.out.println(n1);

        n1 = 3;
        n1 %= 2;
        System.out.println(n1);

        n1 = 3;
//      经测试，发现n1 /= 1.5等价于n1 = (int)(n1/1.5)而不是n1 = n1/(int)1.5,所以结果是2而不是3
        n1 /= 1.5;
        System.out.println(n1);
    }

    @Test
    public void test3() {//一元加减
        int n1 = 2;
        int n2 = -n1;
        int n3 = -n2;
        int n4 = +n2;
        System.out.println(n2);
        System.out.println(n3);
        System.out.println(n4);

        short s1 = 2;
//      一元加将short类型提升为int类型，所以下面语句报错
//      short s2 = +s1;
        int s2 = +s1;
        System.out.println(s2);
    }

    @Test
    public void test4() {//自动递增和递减
        int n1 = 5;
        int r1 = 1 + ++n1;
        System.out.println(n1);
        System.out.println(r1);

        int n2 = 5;
        int r2 = 1 + n2++;
        System.out.println(n2);
        System.out.println(r2);

        int n3 = 5;
        int r3 = --n3;
        System.out.println(n3);
        System.out.println(r3);

        int n4 = 5;
        int r4 = n4--;
        System.out.println(n4);
        System.out.println(r4);
    }

    @Test
    public void test5() {//关系运算符
        System.out.println(5 > 3);
        System.out.println(5 > 3.0);
        System.out.println(5 < 3);
        System.out.println(5 == 3);
        System.out.println(5 != 3);
    }

    @Test
    public void test6() {//逻辑运算符
        System.out.println(5 == 5 && 3.1 == 3);
        System.out.println(5 == 5 && 3.0 == 3);
        System.out.println(5 == 5 || 3.1 == 3);
        System.out.println(5 == 3 || 3 == 3.1);
        System.out.println(!(5 == 3 || 3.1 == 3));
    }

    @Test
    public void test7() {//自动类型转换
        double d1 = 1F;
        double d2 = 1L;
        short s1 = 1;
//      自动类型转换只能小转大，int值1000000大于short的取值区间，无法自动转换
//      short s2 = 1000000;
    }

    @Test
    public void test8() {//强制类型转换
        short s1 = 1;
        int n1 = s1;
//      int到short，精度下降，不能直接转换，所以报错
//      short s2 = n1;
        short s2 = (short) n1;

        int n2 = 100000;
        short s3 = (short) n2;
//      s3的结果是-31072，强制转换会造成精度丢失，结果不准确
        System.out.println(s3);
    }

    @Test
    public void test9() {//包装类
        List<Integer> list1 = new ArrayList<>();
//      基本数据类型不能用于定义泛型，所以下面语句报错
//      List<int> list2 = new ArrayList<>();
        int n1 = Integer.parseInt("100");
        System.out.println(n1);
        int n2 = new Integer(10).intValue();
        System.out.println(n2);
        boolean b1 = Boolean.valueOf("true");
        System.out.println(b1);
        boolean b2 = Boolean.valueOf("tRue");
        System.out.println(b2);
    }
}
