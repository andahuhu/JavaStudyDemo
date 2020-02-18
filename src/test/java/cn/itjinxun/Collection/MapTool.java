package cn.itjinxun.Collection;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MapTool {
    @Test
    public void test1(){
        //两个工具类：Arrays，Collections
        Integer[] intArr = {1,3,5,6,4,2};
        System.out.println(Arrays.toString(intArr));
        Arrays.sort(intArr);
        System.out.println(Arrays.toString(intArr));

        //数组和集合的转换
        //数组 —> 集合
        //asList 方法，如果参数是一个基本数据类型的数组，会将数组整体作为一个元素
        //      集合里面不能存放基本数据类型的元素
        //asList 转换后的集合不能改变结构    。
        List<Integer> list = Arrays.asList(intArr);
        System.out.println(list.size());
        System.out.println(list);
        //list.add(1);
        //list.remove(1);
        //集合 -> 数组
        Integer[] arr = list.toArray(new Integer[list.size()]);
        System.out.println(Arrays.toString(arr));

        List<String> list1 = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list1.add(""+i);
        }
        /*list1 = Collections.nCopies(10,"1");
        System.out.println(list1);*/
        System.out.println(list1);
        List<String> subList = list1.subList(list1.size()-3,list1.size());
        System.out.println(subList);
        subList.clear();
        System.out.println(subList);
        System.out.println(list1);

        list1.add("10");
        System.out.println(list1);

        list1 = Collections.unmodifiableList(list1);
        //list1.add("11");
    }
}
