package cn.itjinxun.CodeBlockAndFlowControl;

import org.junit.Test;

public class CodeBlockTest {
    @Test
    public void testCodeBlock(){//代码块
        int n1 = 100;
        System.out.println(n1);
        {
//          int n1 = 20;
            int n2 = 20;
            System.out.println(n2);
            {
                System.out.println(n1+n2);
            }
        }
//      System.out.println(n2);
        int n2 = 30;
        System.out.println(n2);
    }
}
