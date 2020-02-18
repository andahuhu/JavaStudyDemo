package cn.itjinxun.Collection;

import org.junit.Test;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {
    /*
    * 内容 - Map
    *
    * 散列表相关知识
    * HashMap
    *   内部实现
    *   常用方法
    * TreeMap
    * */
    /*
    * 散列表 HashTable：也是哈希表。
    * 根据数组可以使用下标的方式来快速随机访问来实现的
    * 比如：
    *   存放一组数据:aaa,cde,bfk,...
    *   如何快速的定位和查找？
    *
    *   String[] str;
    *   哈希函数：将关键字转化为正整数，
    *   int hashFn(Object object)
    *   aaa -> 256
    *   cde -> 258
    *   bfk -> 259
    *   aak -> 256
    *
    *   str[256] = "aaa"
    *   str[258] = "cde"
    *   str[259] = "bfk"
    *
    *   哈希函数的最理想状态：
    *       1、哈希结果应该是一个正整数
    *       2、str1 == str2 , hash(str1) == hash(str2)
    *       3、str1 != str2 , hash(str1) != hash(str2)
    *
    *   第三种情况基本不可能，不会存在这么一种函数。
    *   MD5,SHA,CRC 这些算法都可能产生重复的值
    *
    *   哈希冲突：不同的键值，通过哈希函数返回了相同的结果
    *
    *   如何解决哈希冲突：链表方式
    *   数组里面不直接存值：存一个自定义对象。
    *   Node{
    *       Node next;   //下一个节点
    *       Node pre;    //前一个节点
    *       Object item; //值
    *   }
    *   aaa -> 256
    *   aak -> 256
    *   str[256] = { pre : null, item : aaa, next : null};
    *   str[256] = { pre : null, item : aak, next : 指向aaa};
    *              { pre : 指向aak, item : aaa, next : null};
    * */

    @Test
    public void test1(){
        //HashMap
        //1、构建
        HashMap<String,Student> map = new HashMap();
        //2、添加
        //new MapTest().new Student("",1);
        Student s1 = map.put("001",new Student("张三",20));
        map.put("002",new Student("李四",22));
        map.put("005",new Student("王五",22));
        map.put("003",new Student("赵柳",22));
        map.put("008",new Student("胜七",22));
        map.put("006",new Student("重八",22));
        Student s2 = map.put("001",new Student("张三2",22));
        System.out.println("s1 = " + s1);
        System.out.println("s2 = " + s2);
        //3、遍历
        //键值 - 值
        //Map 严格意义上讲，不是一个集合，但是它可以返回3个视图，
        //可以把这三个视图当做集合类来操作：
        //3.1、键值视图，Set
        //3.2、值视图，Collection
        //3.3、键值对视图，Entry
        Set<String> keys = map.keySet();
        System.out.println(keys);
        Collection<Student> values = map.values();
        System.out.println(values);
        Set<Map.Entry<String,Student>> kv = map.entrySet();
        System.out.println(kv);
        for (Map.Entry<String,Student> entry : kv) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }

        for (String key : keys) {
            System.out.println(key);
            Student val = map.get(key);
            System.out.println("map.getValue:" + val);
        }
        //4、删除
        map.remove("001");
        System.out.println(map);
        //List是有序的 list.remove(int index); list.remove(Object object)
        //Set,Map 是无序的，不是使用下标的方式获取

        //特殊元素 null
        map.put(null,new Student("小孩",11));
        map.put(null,null);
        System.out.println(map);

        HashMap<String,Student> map2 = new HashMap(map);
        System.out.println(map2);

        HashMap<String,Student> map3 = new HashMap(10);

        //构建：1、无参数构建；2、使用一个已存在的map作为初始化值；3、指定容量大小
        //put(key,value)
        //  1、key不存在，直接将key -> value 存储，并返回 null
        //  2、key已存在，将key值对应的value值替换为新值，并返回旧值
        //V get(key)
        //  1、key存在，返回key对应的值
        //  2、key不存在，返回null
        //key - value 是否存在
        //  1、key存在:map.containsKey(key);
        //  2、value存在:map.containsValue(value);
        map.put("007",null);
        //if(map.get("007") == null){
        if(!map.containsKey("007")){
            System.out.println("007不存在");
        }else{
            System.out.println("007存在");
        }
        System.out.println(map);

        Student stu = new Student("李四",22);
        System.out.println(map.containsValue(stu));
    }

    @Test
    public void test2(){
        Map<Key,Student> map = new HashMap<>();
        map.put(new Key(1),new Student("张三",22));
        map.put(new Key(1),new Student("李四",22));
        System.out.println(map);
    }

    static class Key{
        private Integer i;

        public Key(Integer i) {
            this.i = i;
        }

        @Override
        public int hashCode() {
            return i == null ? 0 : i.hashCode();
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj){
                return true;
            }
            if(obj instanceof Key){
                Key key = (Key) obj;
                return i != null && i.equals(key.i);
            }
            return false;
        }

        @Override
        public String toString() {
            return i+"";
        }
    }

    static class Student{
        private String name;
        private Integer age;

        public Student(String name, Integer age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public boolean equals(Object obj) {
            if(this == obj){
                return true;
            }
            if(obj instanceof Student){
                Student stu = (Student) obj;
                if(name != null && name.equals(stu.name)
                    && age != null && age.equals(stu.age)){
                    return true;
                }
            }
            return false;
        }

        @Override
        public String toString() {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append("{");
            stringBuilder.append("name:");
            stringBuilder.append(name);
            stringBuilder.append(",");
            stringBuilder.append("age:");
            stringBuilder.append(age);
            stringBuilder.append("}");
            return stringBuilder.toString();
        }
    }
}
