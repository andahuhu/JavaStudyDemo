package cn.itjinxun.DataTypeAndOperator;

import org.junit.Test;

public class DataTypeTest {
    @Test
    public void test1(){//整数类型表示
        //short的最大值是32767，程序会在编译时报错
        //short s1 = 32768;

        //数值计算时，如果计算结果超过变量定义的数据类型的最大值，编译运行时不会报错，但是会返回一个错误的结果
        Integer n1 = 2*Integer.MAX_VALUE;
        System.out.println(n1);

        long n2 = 10000L;
        System.out.println(n2);

        int n3 = 0x0f;//16进制
        System.out.println(n3);

        int n4 = 010;//8进制
        System.out.println(n4);

        int n5 = 0b1_00_01;//二进制
        System.out.println(n5);
    }

    @Test
    public void test2(){//浮点类型表示
        //数值类型都可以把值范围小的直接赋值给大的
        float f1 = 3;
        float f2 = 3L;
        float f3 = 3.14f;

        //没有后缀的小数默认是double类型，赋值给float类型时会在编译报错
        //float f4 = 3.14;

        double d1 = 3.14;
        double d2 = 3.14d;
        double d3 = 3.14f;

//      期望值是0.9，实际值是0.8999999999999999
        System.out.println(2.0-1.1);
//      期望值是0.3，实际值是0.30000000000000004
        System.out.println(3*0.1);
//      期望值是0.2，实际值是0.2
        System.out.println(2*0.1);

        double d4 = Double.MAX_VALUE*2;
        System.out.println(d4);

        double d5 = Double.NaN;
        System.out.println(d5 == Double.NaN);
        System.out.println(Double.isNaN(d5));
    }

    @Test
    public void test3(){//字符类型表示
        char c1 = 'A';
        char c2 = '\u0000';
        char c3 = '\uFFFF';
        char c4 = 65;
        System.out.println(c4);
    }

    @Test
    public void test4(){//布尔类型
        boolean b1 = false;
//      整数类型不能转为布尔类型，所以下面语句会编译报错
//      System.out.println(b1 == 1);
    }

    @Test
    public void test5(){//变量
        int n1;
//      n1在使用（打印）前未初始化，所以下面语句会编译报错
//      System.out.println(n1);

        int n2 = 100;
        System.out.println(n2);

        int n3;
        n3 = 10;
        System.out.println(n3);

        System.out.println(Character.isJavaIdentifierStart('A'));
        System.out.println(Character.isJavaIdentifierStart('a'));
        System.out.println(Character.isJavaIdentifierStart('$'));
        System.out.println(Character.isJavaIdentifierStart('_'));
        System.out.println(Character.isJavaIdentifierStart('2'));

        System.out.println(Character.isJavaIdentifierPart('A'));
        System.out.println(Character.isJavaIdentifierPart('a'));
        System.out.println(Character.isJavaIdentifierPart('$'));
        System.out.println(Character.isJavaIdentifierPart('_'));
        System.out.println(Character.isJavaIdentifierPart('2'));
    }

    @Test
    public void test6(){//常量
        final int MAX_VALUE = 100;
//      MAX_VALUE = 100;

        final int MIN_VALUE;
        MIN_VALUE = 1;
//      MIN_VALUE = 2;
    }
}
