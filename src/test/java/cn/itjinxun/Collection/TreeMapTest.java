package cn.itjinxun.Collection;

import org.junit.Test;

import java.util.*;

public class TreeMapTest {
    /*
    * HashMap 无序
    * TreeMap 有序，和List有序不一样（排序规则）
    * 1、构造
    * 2、添加/删除/遍历/修改（CRUD - 增删改查）
    * */
    @Test
    public void test1(){
        TreeMap<XueHao, String> map = new TreeMap<>();
        /*map.put("1","张三,22");
        map.put("3","李四,20");
        map.put("2","王五,21");*/
        map.put(new XueHao(1),"张三,22");
        map.put(new XueHao(3),"李四,20");
        map.put(new XueHao(2),"王五,21");
        map.put(new XueHao(9),"王五,21");
        map.put(new XueHao(5),"王五,21");

        System.out.println(map.keySet());
        System.out.println(map.values());
        System.out.println(map.entrySet());
        for (Map.Entry<XueHao, String> entry : map.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
        //当put添加元素或者remove删除元素时：
        //  1、使用比较器来进行比较两个元素是否相等，而不是使用equals方法比较是否相等；
        //  2、优先使用TreeMap构建时传入的 Comparator 比较器，
        //      如果未指定，则使用Key值对象实现 Comparable 的 compareTo 方法
        map.remove(new XueHao(5));
        System.out.println(map);

        String oldValue = map.put(new XueHao(5),"五-Update");
        System.out.println(oldValue);
        System.out.println(map);
    }
    /*
    * TreeMap是有序的，这个有序是指按照key值排序
    * 那么key是如何排序？
    * 1、构建TreeMap时，未指定排序器（即 Comparator 接口实现），那么key值对象就必须实现排序接口 Comparable
    * 2、构建TreeMap时，指定了排序器，那么key值对象可以不实现排序接口 Comparable
    * */
    @Test
    public void test2(){
        //final boolean ascOrder = false;
        //TreeMap<BaseXueHao, String> map = new TreeMap();
        TreeMap<BaseXueHao, String> map = new TreeMap(
                XueHaoOrderFactory.getComparator(false)
        );
        map.put(new BaseXueHao(1),"第一个学生");
        map.put(new BaseXueHao(3),"第三个学生");
        map.put(new BaseXueHao(2),"第二个学生");
        map.put(new BaseXueHao(5),"第五个学生");
        map.put(new BaseXueHao(null),"第五个学生");
        System.out.println(map);
    }

    @Test
    public void test3(){
        System.out.println("使用HashMap");
        HashMap<BaseXueHao, String> map = new HashMap();
        map.put(new BaseXueHao(1),"第一个学生");
        map.put(new BaseXueHao(3),"第三个学生");
        BaseXueHao base5 = new BaseXueHao(5);
        System.out.println("base5的hashcode = " + base5.hashCode());
        map.put(base5,"第五个学生");
        System.out.println("删除前"+map);
        BaseXueHao base51 = new BaseXueHao(5);
        System.out.println("base51的hashcode = " + base51.hashCode());
        map.remove(base51);
        System.out.println("删除后"+map);
    }
    /*
    * LinkedHashMap 具有和 HashMap 一样的功能
    * 增强：保持了元素插入的顺序
    * LinkedHashMap 在 HashMap 的基础上增加了如下内容：
    * head 指向按插入顺序，第一个元素的引用
    * tail 指向按插入顺序，最后一个元素的引用
    * 对每一个元素对象，Entry or Node 增加了两个属性
    * 1、before，指向按插入顺序，前一个元素的引用
    * 2、after，指向按插入顺序，后一个元素的引用
    * */
    @Test
    public void test4(){
        LinkedHashMap<BaseXueHao, String> map = new LinkedHashMap();
        map.put(new BaseXueHao(1),"第一个学生");
        map.put(new BaseXueHao(5),"第五个学生");
        map.put(new BaseXueHao(3),"第三个学生");
        for (Map.Entry<BaseXueHao, String> entry :
                map.entrySet()) {
            System.out.println(entry.getKey()+"="+entry.getValue());
        }
    }

    /*
    * WeakHashMap 当里面的某个元素不在被使用时，可以被垃圾回收器回收
    * EnumMap key值必须是枚举类型
    * IdentityHashMap key值的哈希值计算方式：System.identityHashCode(key)
    *   而常规的key值的哈希值计算是：key值对象.hashCode()
    *
    *
    * */
    @Test
    public void test5(){
        String str = new String();
        System.out.println(str.hashCode());
        System.out.println(System.identityHashCode(str));

        BaseXueHao base = new BaseXueHao(1);
        System.out.println(base);
        System.out.println(base.hashCode());//地址的十进制数
        System.out.println(System.identityHashCode(base));//地址的十进制数
    }

    static class XueHaoOrderFactory{
        public static Comparator getComparator(boolean isAsc){
            return new Comparator() {
                @Override
                public int compare(Object one, Object two) {
                    if(one instanceof BaseXueHao && two instanceof BaseXueHao){
                        BaseXueHao baseFirst = (BaseXueHao)one;
                        BaseXueHao baseSecond = (BaseXueHao)two;
                        if(baseFirst.index < baseSecond.index){
                            return isAsc ? -1: 1;
                        }
                        if(baseFirst.index == baseSecond.index){
                            return 0;
                        }
                        return isAsc ? 1: -1;
                    }
                    return -1;
                }
            };
        }
    }

    static class BaseXueHao{
        protected Integer index;//学号

        public BaseXueHao(Integer index) {
            if(index == null){
                this.index = 0;
            }else{
                this.index = index;
            }
        }

        /*@Override
        public int hashCode() {
            int hashCode = this.index.hashCode();
            System.out.println("计算哈希值："+index+"，"+hashCode);
            return hashCode;
        }*/

        @Override
        public boolean equals(Object obj) {
            System.out.println("调用了equals方法");
            return true;
        }

        @Override
        public String toString() {
            return "学号:" + index ;
        }
    }

    static class XueHao extends BaseXueHao implements Comparable {
        public XueHao(Integer index) {
            super(index);
        }

        @Override
        public String toString() {
            return super.toString();
        }

        @Override
        public int compareTo(Object obj) {
            if(obj instanceof XueHao){
                XueHao xueHao = (XueHao)obj;
                if(this.index < xueHao.index){
                    return -1;
                }
                if(this.index == xueHao.index){
                    return 0;
                }
                return 1;
            }
            return -1;
        }
    }
}
