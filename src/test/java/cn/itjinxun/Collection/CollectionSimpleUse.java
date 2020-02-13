package cn.itjinxun.Collection;

import org.junit.Test;

import java.util.*;

public class CollectionSimpleUse {

    private void printAllElements(List<String> list){
        //遍历-for循环
        System.out.println("使用for循环遍历：");
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if(i > 0){
                System.out.print(",");
            }
            System.out.print(str);
        }
        System.out.println();
        //遍历-使用迭代器方式
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            String str = iterator.next();
            System.out.println(str);
        }
    }

    class CustomerClass{}

    @Test
    public void test1(){//集合初识
        //集合分为两大类：
        //1、单个元素的序列，全部实现了Collection接口
        //1.1、List，有序的，按照插入顺序排序，可以有重复的元素
        //1.2、Set，集，不可以有重复元素，可以有且只有一个null
        //1.3、Queue，队列，按一定规则进行添加/删除
        //2、键值对，全部实现了Map接口

        //可以通过<>指定列表里要存放的元素类型
        //List<String> list = new ArrayList<>();
        List<String> list = new LinkedList<>();
        list.add("A");
        list.add("C");
        list.add("B");
        list.add("F");
        System.out.println("list的元素个数：" + list.size());

        //遍历-for循环
        System.out.println("使用for循环遍历：");
        for (int i = 0; i < list.size(); i++) {
            String str = list.get(i);
            if(i > 0){
                System.out.print(",");
            }
            System.out.print(str);
        }

        System.out.println();
        /*list.remove(1);
        list.remove("F");
        System.out.println(list);*/

        //遍历-使用迭代器方式
        Iterator<String> iterator = list.iterator();
        //迭代器的位置在集合的元素之间
        //存在n个元素的列表，迭代器的位置可能存在n+1个
        //获取迭代器后，迭代器的位置在第一个元素之前
        //未调用next()方法时,调用remove抛IllegalStateException异常
        //remove方法删除的是调用next()方法时返回的元素（越过的元素）
        //iterator.remove();
        /*System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());*/
        //当迭代器达到最后一个元素时，
        //再调用next()方法时，抛NoSuchElementException异常
        while (iterator.hasNext()){
            //next()方法有两个作用：
            //1、将迭代器移动到下一个位置
            //2、同时返回越过的元素
            String str = iterator.next();
            System.out.println(str);
        }
    }

    @Test
    public void test2() {//集合初识
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("C");
        list1.add("B");
        list1.add("F");
        printAllElements(list1);


        List<String> list2 = new LinkedList<>();
        list2.add("1");
        list2.add("3");
        list2.add("5");
        list2.add("2");
        list2.add("4");
        list2.add("6");
        printAllElements(list2);

        List list3 = new ArrayList();
        list3.add(1);
        list3.add("字符串");
        list3.add(new CollectionSimpleUse().new CustomerClass());
        list3.add(new Date());

        for (int i = 0; i < list3.size(); i++) {
            Object obj = list3.get(i);
            if(obj instanceof String){
                String str = (String)obj;
                System.out.println("字符串："+str);
            }else if (obj instanceof Integer){
                Integer num = (Integer)obj;
                System.out.println("int型数值："+num);
            }else if (obj instanceof Date){
                Date date = (Date)obj;
                System.out.println("日期"+date);
            }else{
                System.out.println("不识别的类型："+obj.getClass().getName());
            }
        }
    }

    @Test
    public void test3() {//集合初识
        //Set，集，不可以有重复元素，可以有且只有一个null
        //可能无序（HashSet）或有序(TreeSet)
        //LinkedHashSet、EnumSet ......
        //所有的集都实现了Set接口，而Set接口继承自Collection接口
        //所以我们说所有的集都实现了Collection接口
        //Set和Collection接口的方法完全一致，仅是用于语义上的区别
        HashSet<String> set = new HashSet<>();
        System.out.println(set instanceof Set);
        System.out.println(set instanceof Collection);
        System.out.println(set instanceof List);

        set.add("A");
        set.add("B");
        set.add("C");
        set.add("D");
        set.add("E");
        set.add("F");
        //遍历-for循环
        //因为是无序的，同样的索引值取出的值可能不一样
        /*for (int i = 0; i < set.size(); i++) {
            String str = set.get(i);
        }*/

        //遍历-迭代器
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //List有序指的是按照插入顺序排序
        //TreeSet有序，指的是元素按照一定规则排序，实现Comparator接口
        TreeSet<String> set2 = new TreeSet<>();
        set2.add("1");
        set2.add("2");
        set2.add("3");
        set2.add("6");
        set2.add("5");
        set2.add("4");
        //遍历-for循环
        /*for (int i = 0; i < set.size(); i++) {
            String str = set.get(i);
        }*/
        //遍历-迭代器
        Iterator<String> iterator2 = set2.iterator();
        while (iterator2.hasNext()){
            System.out.println(iterator2.next());
        }

        //如果需要使用HashSet的查找元素的高性能
        //同时又需要按照元素的插入顺序排序
        LinkedHashSet<String> set3 = new LinkedHashSet<>();
        set3.add("1");
        //add方法如果成功返回true，如果失败返回false
        System.out.println(set3.add(null));
        System.out.println(set3.add(null));
        set3.add("3");
        set3.add("6");
        set3.add("5");
        set3.add("4");
        Iterator<String> iterator3 = set3.iterator();
        while (iterator3.hasNext()){
            System.out.println(iterator3.next());
        }

        //remove方法如果成功返回true，如果失败返回false
        System.out.println(set3.remove("3"));
        System.out.println(set3.remove("7"));
        System.out.println("set3= "+set3);

        Collection<String> removeSet = new LinkedHashSet<>();
        removeSet.add(null);
        removeSet.add("4");
        set3.removeAll(removeSet);
        System.out.println("set3= "+set3);
    }

    @Test
    public void test4() {//集合初识
        List<String> list = new ArrayList<>();
        list.add(null);
        list.add(null);
        list.add("1");
        list.add("2");
        list.add(null);
        list.add("1");
        System.out.println("list = "+list);
        list.remove("3");
        list.remove("1");
        //索引值不在0-size()区间，抛IndexOutOfBoundsException异常
        //list.remove(6);
        System.out.println("list = "+list);
        List<String> removeList = new ArrayList<>();
        removeList.add(null);
        removeList.add("1");
        list.removeAll(removeList);
        System.out.println("list = "+list);
    }
}
