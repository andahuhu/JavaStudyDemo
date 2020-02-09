package itjinxun.InnerClass;

import java.util.ArrayList;
import java.util.List;

public class DoubleInit {
    public static void main(String[] args) {
        List<Integer> numList = new ArrayList();
        numList.add(1);
        numList.add(2);
        numList.add(3);
        numList.add(4);
        numList.add(5);
        System.out.println(numList);
        /*class ArrayListNew extends ArrayList{
            private String name = "";
            {
                //初始化代码块
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        }
        List<Integer> numList2 = new ArrayListNew();
        numList2.add(1);
        numList2.add(2);
        numList2.add(3);
        numList2.add(4);
        numList2.add(5);
        System.out.println(numList2);*/
        List<Integer> numList3 = new ArrayList(){
            //初始化代码块
            {
                add(1);
                add(2);
                add(3);
                add(4);
                add(5);
            }
        };
        System.out.println(numList3);
    }
}
