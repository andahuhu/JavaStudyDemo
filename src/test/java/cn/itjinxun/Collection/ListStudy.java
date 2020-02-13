package cn.itjinxun.Collection;

import org.junit.Test;

import java.util.*;

public class ListStudy {
    /*
    * List主要有两种：ArrayList和LinkedList
    * ArrayList：内部使用数组来实现的
    * LinkedList：内部使用的是一个双向链表来实现
    * 创建：无参数构建；有参数构建：1、指定容量大小，2、复制已存在的List创建
    * 添加：1、头插，2、尾插，3、中间插入
    * 删除：1、头删，2、尾删，3、中间删除
    * 遍历：
    *   1、使用for循环
    *   2、使用迭代器Iterator,ListIterator
    *   3、使用迭代器对List添加，删除操作
    *   4、迭代器使用注意事项：在使用迭代器对列表进行操作时，
    *       原对象不能发生结构性变化，否则迭代器操作会抛出异常
    * 底层实现原理及主要JDK源码：内部存储结构、添加/删除/遍历操作的流程
    * 对List进行排序：冒泡、插入、选择
    * */

    private static void addNumberToList(List<Integer> list, int count, int number){
        Long start = System.currentTimeMillis();
        for (int i = 0; i < count; i++) {
            list.add(number);
        }
        System.out.println("耗时："+(System.currentTimeMillis()-start)+"ms");
    }

    private static void listOpTime(List<Integer> list){
        int times = 100000;
        Long start = System.currentTimeMillis();
        //for循环
        //对于LinkedList，每次get(index)，都会从头开始查找
        //  优化：如果index大于length/2时，从尾部开始查找
        for (int i = 0; i < list.size(); i++) {
            list.get(i);
        }
        System.out.printf("[%s] for循环遍历耗时： %d ms\n",list.getClass().getSimpleName(),(System.currentTimeMillis()-start));

        //Iterator
        start = System.currentTimeMillis();
        Iterator iterator = list.iterator();
        while (iterator.hasNext()){
            iterator.next();
        }
        System.out.printf("[%s] Iterator循环遍历耗时： %d ms\n",list.getClass().getSimpleName(),(System.currentTimeMillis()-start));

        //foreach
        start = System.currentTimeMillis();
        for (Integer i : list) {
        }
        System.out.printf("[%s] foreach循环遍历耗时： %d ms\n",list.getClass().getSimpleName(),(System.currentTimeMillis()-start));

        //在第5位插入10000个1
        start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            list.add(4,1);
        }
        System.out.printf("[%s] 第5位插入%d个1耗时： %d ms\n",list.getClass().getSimpleName(),times,(System.currentTimeMillis()-start));

        //在末尾插入10000个2
        start = System.currentTimeMillis();
        for (int i = 0; i < times; i++) {
            list.add(2);
        }
        System.out.printf("[%s] 末尾插入%d个2耗时： %d ms\n",list.getClass().getSimpleName(),times,(System.currentTimeMillis()-start));
    }

    private static void fill(List<Integer> list){
        for (int i = 0; i < 10000; i++) {
            list.add(i);
        }
    }
    @Test
    public void test1(){
        //创建ArrayList时，如果未指定容量大小，则会创建一个空数组
        //第一次调用add()方法时，将容量扩充为默认容量大小DEFAULT_CAPACITY
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);//默认插入方式，尾插
        list1.add(2);
        list1.add(3);
        list1.add(0,100);//头插
        list1.add(3,20);//中间插入
        list1.set(3,33);
        System.out.println("list1 = "+list1);

        //删除
        list1.remove(0);
        System.out.println("list1 = "+list1);
        list1.remove(list1.size()-1);
        System.out.println("list1 = "+list1);

        //遍历
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
        for (Integer i : list1) {
            System.out.println(i);
        }
        //foreach等效于使用迭代器
        Iterator iterator = list1.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        //如果在创建ArrayList时，能预估数据规模
        //我们就能指定一个初始容量大小，以减少扩容操作
        /*List<Integer> list2 = new ArrayList<>(100);
        for (Integer integer : list1) {
            list2.add(integer);
        }*/
        List<Integer> list2 = new ArrayList<>(list1);
        System.out.println("list2 = "+list2);

        //数组是有容量大小限制，当add操作时，如果数组已满，就会引发扩容操作
        //  1、计算新的容量大小：原来容量的1.5倍
        //  2、按新的容量大小创建一个新的数组
        //  3、将旧的数组里面的元素全部复制到新的数组中去
        //  4、丢弃旧的数组
    }

    @Test
    public void test2(){
        int count = 1000000;
        List<Integer> list1 = new ArrayList<>();
        addNumberToList(list1,count,1);
        List<Integer> list2 = new ArrayList<>(count);
        addNumberToList(list2,count,1);
    }

    @Test
    public void test3(){
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        ListIterator<String> listIterator = list1.listIterator();
        System.out.println("hasPrevious:"+listIterator.hasPrevious());
        System.out.println("hasNext:"+listIterator.hasNext());
        System.out.println("previousIndex:"+listIterator.previousIndex());
        System.out.println("nextIndex:"+listIterator.nextIndex());

        //listIterator.previous();
        //listIterator.next();

        System.out.println("next:"+listIterator.next());
        listIterator.set("A_Update");
        System.out.println("list1 = "+list1);
        listIterator.add("A_New");
        System.out.println("list1 = "+list1);
        System.out.println("previous:"+listIterator.previous());
        //System.out.println("next:"+listIterator.next());
        listIterator.set("A_Update2");
        System.out.println("list1 = "+list1);
        listIterator.remove();
        System.out.println("list1 = "+list1);
        System.out.println("next:"+listIterator.next());
        listIterator.remove();
        System.out.println("list1 = "+list1);
        //迭代器操作元素的时候
        //set()和remove()方法和迭代器的状态有关，更新或者删除的是上一次调用的next()或者previous()方法返回的元素
        //add()方法只和迭代器的位置有关，在当前迭代器位置之前添加元素/
    }

    @Test
    public void test4(){
        //迭代器使用注意事项：在使用迭代器对列表进行操作时，
        //    原对象不能发生结构性变化，否则迭代器操作会抛出异常
        List<String> list1 = new ArrayList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        ListIterator<String> listIterator = list1.listIterator();
        while(listIterator.hasNext()){
            //list1.add("D");
            System.out.println("next:"+listIterator.next());
        }
    }

    @Test
    public void test5(){
        List<String> list1 = new LinkedList<>();
        list1.add("A");
        list1.add("B");
        list1.add("C");
        System.out.println("list1 = "+list1);
        List<String> list2 = new LinkedList<>(list1);
        System.out.println("list2 = "+list2);
        System.out.println(list2.get(0));
        //其余操作和ArrayList一样
    }

    @Test
    public void test6(){
        List<Integer> list1 = new ArrayList<>();
        fill(list1);
        listOpTime(list1);
        List<Integer> list2 = new LinkedList<>();
        fill(list2);
        listOpTime(list2);
    }
}
