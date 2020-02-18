package cn.itjinxun.Collection;

import org.junit.Test;

import java.util.*;

public class SetTest {
    /*
    * 集合类
    * Collection
    *   List 列表
    *   Set 集
    *   Queue 队列
    * Map 键值对，散列
    * Set 内部使用的是对应的 Map 来实现的
    * Map 的 key 值即是存放 Set 的值
    *   key 值对应的 value 存放的是一个固定值 static new Object()
    *   HashSet -> HashMap
    *   TreeSet -> TreeMap
    *   Map 中的 key 值不可以重复，可以是null?
    *   因此，Set 的值不可以重复，可以是null?
    *   TreeSet 是有序的，指的是他的值的顺序
    *   如何排序：
    *       1、Comparator 接口比较两个值；
    *       2、Comparable 接口比较自身和另一个对象
    *   和TreeMap类似，TreeSet内存放的元素必须实现Comparable 接口
    *   但是，如果构造 TreeSet 时，指定了Comparator 接口，那么存放元素可以不用实现 Comparable 接口
    *   TreeSet的值不可以是null?
    *       1、构造TreeSet如果指定了Comparator 接口，则可以存放null；
    *       2、构造TreeSet如果未指定Comparator 接口，add 添加元素时需要
    *           调用元素对象的campareTo()方法（Comparable 接口）去比较元素的大小，因此不能存放null
    * */
    @Test
    public void test1(){
        TreeSet<String> set = new TreeSet();
        set.add("str1"); //内部调用的是map.put("str1",PRESENT)
        set.add(null);
        set.add("");
        set.add("str3");
        set.add("str2");
        set.add("str3");
        set.add(null);
        Iterator<String> iterator = set.iterator(); // map.keySet().iterator()
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }
        set.remove("str3");
        System.out.println(set);
    }

    @Test
    public void test2(){
        TreeSet<TreeMapTest.BaseXueHao> set = new TreeSet(
                new Comparator() {
                    @Override
                    public int compare(Object o1, Object o2) {
                        return 0;
                    }
                }
        );
        set.add(new TreeMapTest.BaseXueHao(1));
    }

    @Test
    public void test3(){
        HashSet<String> hashSet = new HashSet<>();
        //无序，可以存放null，但只能有一个空
        hashSet.add(null);
        hashSet.add("");
        hashSet.add("str3");
        hashSet.add("str2");
        hashSet.add("str3");
        hashSet.add(null);
        System.out.println(hashSet);
        //Set 的主要作用？？？判断某个指定元素在集中是否存在
        String str = "str3";
        if(hashSet.contains(str)){
            System.out.println("包含：" + str);
        }else{
            System.out.println("不包含：" + str);
        }
    }
}
